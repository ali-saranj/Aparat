package ali.saranj.aparat.mapers.video

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.data.network.dto.video.VideoDto

fun VideoDto.toVideo() = Video(
    uid = uid!!,
    id = id,
    title = title!!,
    description = description,
    thumbnailUrl = bigPoster,
    userName = username,
    userId = userid,
    userImageUrl = profilePhoto,
    videoUrl = fileLink,
    pDate = sdate,
    mDate = createDate,
    tags = tagStr,
    categoryName = catName,
    categoryId = catId,
    time = duration,
)