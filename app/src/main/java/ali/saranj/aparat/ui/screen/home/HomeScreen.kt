package ali.saranj.aparat.ui.screen.home

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.ui.components.card.CardVideo
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeUIEvent: ((HomeUiEvent) -> Unit)? = null,
    videoState: HomeVideoState<List<Video>>
) {
    LaunchedEffect(homeUIEvent) {
        homeUIEvent!!.invoke(HomeUiEvent.LoadVideos)
    }

    when (videoState) {
        is HomeVideoState.Error -> {
            Text(text = videoState.exception)
        }
        is HomeVideoState.Loading -> {
            Text(text = "loading")
        }
        is HomeVideoState.NotCalledYet -> {
            Text(text = "hi")
        }

        is HomeVideoState.Success -> {
            HomeContent(listVideo = videoState.data)
        }
    }

}

@Composable
fun HomeContent(modifier: Modifier = Modifier, listVideo: List<Video>) {
    LazyColumn {
        items(listVideo){
            CardVideo(video = it)
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
//    HomeScreen()
}