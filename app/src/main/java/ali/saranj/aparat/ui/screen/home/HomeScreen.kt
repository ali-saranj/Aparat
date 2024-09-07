package ali.saranj.aparat.ui.screen.home

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.ui.components.card.CardCategory
import ali.saranj.aparat.ui.components.card.CardVideo
import ali.saranj.aparat.ui.components.card.CardVideoMost
import ali.saranj.aparat.utils.UIState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeUIEvent = viewModel::handleEvent
    val videoMostState = viewModel.mostVideosUiState.value
    val categoryState = viewModel.categoriesUiState.value
    var isVideoLoading by remember {
        mutableStateOf(false)
    }
    var mostViewedVideos by remember {
        mutableStateOf(listOf<Video>())
    }
    var errorMessageMostViewedVideos by remember {
        mutableStateOf("")
    }


    LaunchedEffect(homeUIEvent) {
        homeUIEvent.invoke(HomeUiEvent.LoadMostVideos)
        homeUIEvent.invoke(HomeUiEvent.LoadCategorise)
    }

    when (videoMostState) {
        is UIState.Error -> {
            isVideoLoading = false
            errorMessageMostViewedVideos = videoMostState.exception
        }

        is UIState.Loading -> {
            isVideoLoading = true
            mostViewedVideos = emptyList()
            errorMessageMostViewedVideos = ""
        }

        is UIState.Success -> {
            isVideoLoading = false
            mostViewedVideos = videoMostState.data
            errorMessageMostViewedVideos = ""
        }

    }

    var isCategoryLoading by remember {
        mutableStateOf(false)
    }
    var categories by remember {
        mutableStateOf(listOf<Category>())
    }
    var errorMessageCategories by remember {
        mutableStateOf("")
    }

    when (categoryState) {
        is UIState.Error -> {
            isCategoryLoading = false
            errorMessageCategories = categoryState.exception
        }

        is UIState.Loading -> {
            isCategoryLoading = true
            errorMessageCategories = ""
            categories = emptyList()
        }

        is UIState.Success -> {
            isCategoryLoading = false
            errorMessageCategories = ""
            categories = categoryState.data
        }
    }

    LaunchedEffect(homeUIEvent) {
        homeUIEvent.invoke(HomeUiEvent.LoadMostVideos)
        homeUIEvent.invoke(HomeUiEvent.LoadCategorise)
    }

    Column {

    }

}


@Composable
fun HomeCategoriesView(modifier: Modifier = Modifier, categories: List<Category>) {
    LazyRow {
        items(categories) { category ->
            CardCategory(
                category = category,
                modifier = modifier.padding(4.dp)
            ) {

            }
        }
    }
}

@Composable
fun HomeContent(modifier: Modifier = Modifier, listVideo: List<Video>) {
    LazyColumn {
        items(listVideo) {
            CardVideo(video = it)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageMostViewVideo(modifier: Modifier = Modifier, listVideo: List<Video>) {
    val pagerState = rememberPagerState {
        listVideo.size
    }


    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) { page: Int ->
        CardVideoMost(modifier = Modifier.padding(4.dp), video = listVideo[page])
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % listVideo.size)
        }

    }
}


@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
//    HomeScreen()
}