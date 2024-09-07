package ali.saranj.aparat.data.models

data class Video(
    var uid: String,
    var id: String?,
    var title: String,
    var description: String?,
    var thumbnailUrl: String?,
    var userName: String?,
    var userId: String?,
    var userImageUrl: String?,
    var videoUrl: String?,
    var pDate: String?,
    var mDate: String?,
    var tags:String?,
    val categoryName:String?,
    val categoryId: Int?,
    val time: Int?,
    val visitCunt:Int?,
)