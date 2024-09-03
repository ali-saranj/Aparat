package ali.saranj.aparat.ui.components.card

import ali.saranj.aparat.R
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.ui.navigation.NavigationItem
import ali.saranj.aparat.ui.theme.MyApplicationTheme
import ali.saranj.aparat.utils.Time
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun CardVideo(
    modifier: Modifier = Modifier,
    video: Video
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Card {
            Box {
                AsyncImage(
                    modifier = Modifier.size(150.dp, 100.dp),
                    model = video.thumbnailUrl,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    error = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = video.title
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0x88000000))
                        .padding(4.dp, 2.dp),
                    text = Time().getFormattedTime(video.time ?: 0),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White

                )
            }

        }
        Spacer(modifier = Modifier.size(10.dp))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = video.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.size(4.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Text(text = video.userName ?: "", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.size(8.dp))

                AsyncImage(
                    modifier = Modifier
                        .size(24.dp, 24.dp)
                        .clip(CircleShape),
                    model = video.userImageUrl,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    error = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = video.userName
                )
            }

            Spacer(modifier = Modifier.size(4.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
            ) {
                Text(text = video.mDate ?: "", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = video.categoryName ?: "", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}


@Preview(name = "CardVideo", showBackground = true)
@Composable
private fun PreviewCardVideo() {
    MyApplicationTheme {
        CardVideo(
            modifier = Modifier,
            video = Video(
                uid = "1",
                id = "1",
                title = "Test Videofdfdfdfdf",
                description = "Description of the video",
                thumbnailUrl = "https://example.com/thumbnail.jpg",
                userName = "User Name",
                userId = "user_id",
                userImageUrl = "https://example.com/user_image.jpg",
                videoUrl = "https://example.com/video.mp4",
                pDate = "2022-01-01",
                mDate = "2022-01-01",
                tags = "#tag1 #tag2",
                categoryName = "Category Name",
                categoryId = 1,
                time = 12036 // 2 minutes
            )
        )
    }


}