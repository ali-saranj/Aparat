package ali.saranj.aparat.ui.screen.home

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.data.network.dto.video.mostviewed.MostViewedVideos
import ali.saranj.aparat.data.repository.category.CategoryRepositoryImpl
import ali.saranj.aparat.data.repository.video.VideoRepositoryImpl
import ali.saranj.aparat.utils.Response
import ali.saranj.aparat.utils.UIState
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

    var mostVideosUiState = mutableStateOf<UIState<List<Video>>>(UIState.Loading)
        private set


    var categoriesUiState = mutableStateOf<UIState<List<Category>>>(UIState.Loading)
        private set


    fun handleEvent(homeEvent: HomeUiEvent) {
        when (homeEvent) {
            is HomeUiEvent.GetVideosByCategory -> TODO()
            is HomeUiEvent.LoadCategorise -> getCategories()
            is HomeUiEvent.LoadMostVideos -> getMostVideos()
        }
    }

    private fun getCategories() = viewModelScope.launch {
        categoriesUiState.value = UIState.Loading
        repositoryCategory.getCategories().collectLatest {
            when (it) {
                is Response.Error -> categoriesUiState.value = UIState.Error(it.exception)
                is Response.Success -> categoriesUiState.value = UIState.Success(it.data)
            }
        }
    }

    private fun getMostVideos() = viewModelScope.launch {
        mostVideosUiState.value = UIState.Loading
        repositoryVideo.getMostViewedVideos().collectLatest {
            when (it) {
                is Response.Error -> mostVideosUiState.value = UIState.Error(it.exception)
                is Response.Success -> mostVideosUiState.value = UIState.Success(it.data)
            }
        }
    }


}