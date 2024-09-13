package ali.saranj.aparat.ui.components.card

import ali.saranj.aparat.R
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.ui.navigation.NavigationItem
import ali.saranj.aparat.ui.theme.MyApplicationTheme
import ali.saranj.aparat.utils.Time
import androidx.compose.foundation.Image
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
import com.valentinilk.shimmer.shimmer

@Composable
fun CardVideo(
    modifier: Modifier = Modifier,
    video: Video
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Box(modifier) {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp),
                model = video.thumbnailUrl,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.frame_2),
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = video.title
            )
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.BottomStart)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0x88000000))
                    .padding(4.dp, 2.dp),
                text = Time().getFormattedTime(video.time ?: 0),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier.padding(8.dp, 2.dp),
            text = video.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 1.dp)
        ) {
            Text(text = video.pDate ?: "", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "بازدید ${video.visitCunt.toString()}" ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 1.dp)
                .height(1.dp)
                .background(color = Color(0xFFE0E0E0))
        )
        Spacer(modifier = Modifier.size(12.dp))

    }
}

@Composable
fun CardVideoWithShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .shimmer()
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.size(8.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(200.dp, 20.dp)
                .shimmer()
                .background(Color.Gray)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 1.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp, 20.dp)
                    .shimmer()
                    .background(Color.Gray),
            )
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp, 20.dp)
                    .shimmer()
                    .background(Color.Gray),
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 1.dp)
                .height(1.dp)
                .background(color = Color(0xFFE0E0E0))
        )
        Spacer(modifier = Modifier.size(12.dp))

    }
}

@Preview(name = "CardVideoWithShimmer", showBackground = true)
@Composable
private fun PreviewCardVideoWithShimmer() {
    CardVideoWithShimmer()
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
                time = 12036,
                visitCunt = 33
            )
        )
    }


}