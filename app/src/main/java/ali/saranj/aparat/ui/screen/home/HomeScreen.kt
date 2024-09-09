package ali.saranj.aparat.ui.screen.home

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.ui.components.button.ButtonCategory
import ali.saranj.aparat.ui.components.card.CardCategory
import ali.saranj.aparat.ui.components.card.CardCategoryWithShimmer
import ali.saranj.aparat.ui.components.card.CardVideo
import ali.saranj.aparat.ui.components.card.CardVideoMost
import ali.saranj.aparat.ui.components.card.CardVideoMostWithShimmer
import ali.saranj.aparat.utils.UIState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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


    LaunchedEffect(homeUIEvent) {
        homeUIEvent.invoke(HomeUiEvent.LoadMostVideos)
        homeUIEvent.invoke(HomeUiEvent.LoadCategorise)

    }


    Column(Modifier.fillMaxSize()) {
        when (videoMostState) {
            is UIState.Loading -> HomePageMostViewVideo()
            is UIState.Success -> HomePageMostViewVideo(
                modifier = Modifier.padding(top = 8.dp),
                listVideo = videoMostState.data
            )

            is UIState.Error -> Text(text = videoMostState.exception)
        }

        when (categoryState) {
            is UIState.Loading -> HomeCategoriesView()
            is UIState.Success -> HomeCategoriesView(
                modifier = Modifier.padding(top = 8.dp),
                categories = categoryState.data
            ){
                homeUIEvent.invoke(HomeUiEvent.GoToCategoryDetails(it))
            }

            is UIState.Error -> Text(text = categoryState.exception)
        }
    }


}


@Composable
fun HomeCategoriesView(modifier: Modifier = Modifier, categories: List<Category>,onCategoryClick: (Category) -> Unit) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "لیست دسته بندی ها",
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow {
            items(categories) { category ->
                Spacer(modifier = Modifier.size(4.dp))
                ButtonCategory(
                    category = category,
                    modifier = modifier.padding(4.dp)
                ) { category ->
                    onCategoryClick(category)
                }
            }
        }
    }

}

@Composable
fun HomeCategoriesView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "لیست دسته بندی ها",
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow {
            items(20) {
                Spacer(modifier = Modifier.size(4.dp))
                CardCategoryWithShimmer()
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

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = " ویدیو های پر بازدید ",
            style = MaterialTheme.typography.titleMedium
        )
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) { page: Int ->
            CardVideoMost(modifier = Modifier.padding(4.dp), video = listVideo[page])
        }
    }


    LaunchedEffect("") {
        while (true) {
            delay(3000)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % listVideo.size)
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageMostViewVideo(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState {
        10
    }

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = " ویدیو های پر بازدید ",
            style = MaterialTheme.typography.titleMedium
        )
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) { page: Int ->
            CardVideoMostWithShimmer()
        }
    }

}


@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
//    HomeScreen()
}