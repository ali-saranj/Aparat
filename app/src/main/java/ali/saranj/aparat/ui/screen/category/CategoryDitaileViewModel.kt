package ali.saranj.aparat.ui.screen.category

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.data.repository.video.VideoRepositoryImpl
import ali.saranj.aparat.ui.navigation.NavAction
import ali.saranj.aparat.utils.Response
import ali.saranj.aparat.utils.UIState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val repository: VideoRepositoryImpl,
    private val navAction: NavAction
) : ViewModel() {

    var categoryDetailState = mutableStateOf<UIState<List<Video>>>(UIState.Loading)
        private set


    fun handelEvent(categoryDetailEvent: CategoryDetailEvent) {
        when (categoryDetailEvent) {
            is CategoryDetailEvent.BackToHomeScreen -> backToHome()
            is CategoryDetailEvent.LoadVideoByCategory -> loadVideoByCategory(categoryDetailEvent.categoryId)
        }
    }


    private fun loadVideoByCategory(categoryId: Int) = viewModelScope.launch {
        categoryDetailState.value = UIState.Loading
        repository.getVideoByCategory(id = categoryId, 500).collectLatest {
            when (it) {
                is Response.Error -> categoryDetailState.value = UIState.Error(exception = it.exception)
                is Response.Success -> categoryDetailState.value = UIState.Success(data = it.data)
            }
        }
    }

    private fun backToHome() {
        navAction.navigateBack()
    }
}