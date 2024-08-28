package ali.saranj.aparat.data.network.dto.video

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("autoplay")
    val autoplay: Boolean?,
    @SerializedName("big_poster")
    val bigPoster: String?,
    @SerializedName("can_download")
    val canDownload: Boolean?,
    @SerializedName("cat_id")
    val catId: Int?,
    @SerializedName("cat_name")
    val catName: String?,
    @SerializedName("cat_name_en")
    val catNameEn: String?,
    @SerializedName("cost_type")
    val costType: CostType?,
    @SerializedName("create_date")
    val createDate: String?,
    @SerializedName("360d")
    val d: Boolean?,
    @SerializedName("deleteurl")
    val deleteurl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("file_link")
    val fileLink: String?,
    @SerializedName("file_link_all")
    val fileLinkAll: List<Any?>?,
    @SerializedName("follow_link")
    val followLink: String?,
    @SerializedName("follow_status")
    val followStatus: String?,
    @SerializedName("frame")
    val frame: String?,
    @SerializedName("has_comment")
    val hasComment: String?,
    @SerializedName("has_comment_txt")
    val hasCommentTxt: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("ip_address")
    val ipAddress: String?,
    @SerializedName("isHidden")
    val isHidden: Any?,
    @SerializedName("like_cnt")
    val likeCnt: Int?,
    @SerializedName("official")
    val official: String?,
    @SerializedName("playeradvertcornel")
    val playeradvertcornel: String?,
    @SerializedName("process")
    val process: String?,
    @SerializedName("profilePhoto")
    val profilePhoto: String?,
    @SerializedName("sdate")
    val sdate: String?,
    @SerializedName("sdate_timediff")
    val sdateTimediff: Int?,
    @SerializedName("sender_name")
    val senderName: String?,
    @SerializedName("size")
    val size: String?,
    @SerializedName("small_poster")
    val smallPoster: String?,
    @SerializedName("tag_str")
    val tagStr: String?,
    @SerializedName("tags")
    val tags: List<Tag?>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("uid")
    val uid: String?,
    @SerializedName("userid")
    val userid: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("video_date_status")
    val videoDateStatus: String?,
    @SerializedName("visit_cnt")
    val visitCnt: Int?,
)