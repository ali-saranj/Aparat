package ali.saranj.aparat.ui.components.card

import ali.saranj.aparat.R
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.utils.Time
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CardVideoMost(modifier: Modifier = Modifier, video: Video) {


    Card (modifier = modifier){
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = video.thumbnailUrl,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = video.title
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFFF0000))
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = video.visitCunt.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
                Spacer(modifier = Modifier.size(4.dp))
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_eye_24),
                    contentDescription = "eye",
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.BottomStart)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0x88000000))
                    .padding(4.dp, 2.dp),
                text = Time().getFormattedTime(video.time ?: 0),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }

    }
}

@Preview
@Composable
private fun CardVideo() {
    CardVideoMost(
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
            time = 12036,// 2 minutes
            visitCunt = 10000
        )
    )
}