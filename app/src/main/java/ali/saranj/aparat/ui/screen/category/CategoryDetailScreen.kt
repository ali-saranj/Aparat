package ali.saranj.aparat.ui.screen.category

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.ui.components.card.CardVideo
import ali.saranj.aparat.ui.components.card.CardVideoWithShimmer
import ali.saranj.aparat.utils.UIState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreen(
    modifier: Modifier = Modifier,
    categoryId: String?,
    categoryName: String?,
    viewModel: CategoryDetailViewModel = hiltViewModel(),
) {
    val event = viewModel::handelEvent
    val state = viewModel.categoryDetailState.value

    LaunchedEffect(event) {
        event.invoke(CategoryDetailEvent.LoadVideoByCategory(categoryId = categoryId!!.toInt()))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = { Text(text = categoryName!!) },
                actions = {
                    IconButton(onClick = { event.invoke(CategoryDetailEvent.BackToHomeScreen) }) {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "back")
                    }
                })
        }
    ) { paddingValues ->
        when (state) {
            is UIState.Error -> Box(
                modifier = Modifier.padding(paddingValues),
            ) {
                Text(text = state.exception)
            }

            is UIState.Loading -> CategoryDetailContent(modifier = modifier.padding(paddingValues))
            is UIState.Success -> CategoryDetailContent(
                modifier = modifier.padding(paddingValues),
                listVideo = state.data
            )
        }
    }
}

@Composable
fun CategoryDetailContent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(10) {
            CardVideoWithShimmer()
        }
    }
}

@Composable
fun CategoryDetailContent(listVideo: List<Video>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(listVideo) {
            CardVideo(video = it)
        }
    }
}

@Preview(name = "CategoryScreen")
@Composable
private fun PreviewCategoryScreen() {
    CategoryDetailScreen(categoryId = "sdasd", categoryName = "")
}