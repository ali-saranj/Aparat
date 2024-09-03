package ali.saranj.aparat.ui.screen.home

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.data.repository.category.CategoryRepository
import ali.saranj.aparat.data.repository.category.CategoryRepositoryImpl
import ali.saranj.aparat.data.repository.video.VideoRepository
import ali.saranj.aparat.data.repository.video.VideoRepositoryImpl
import ali.saranj.aparat.utils.Response
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   val repositoryVideo: VideoRepositoryImpl,
   val repositoryCategory: CategoryRepositoryImpl
) : ViewModel() {

    var homeUiState = mutableStateOf<HomeVideoState<List<Video>>>(HomeVideoState.NotCalledYet)
        private set



    fun handleEvent(homeEvent: HomeUiEvent) {
        when (homeEvent) {
            is HomeUiEvent.GetVideosByCategory -> TODO()
            is HomeUiEvent.LoadCategorise -> TODO()
            is HomeUiEvent.LoadVideos -> getVideos()
        }
    }

    private fun getVideos() = viewModelScope.launch {
        homeUiState.value = HomeVideoState.Loading
       repositoryVideo.getMostViewedVideos().collectLatest {
            when(it){
                is Response.Error -> homeUiState.value = HomeVideoState.Error(it.exception)
                is Response.Success -> homeUiState.value = HomeVideoState.Success(it.data)
            }
        }
    }


}