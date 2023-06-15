interface Attachment {
    val type: String
}

class PhotoAttachment(override val type: String = "Photo", val photo: Photo = Photo(1, 2, "smile", 200)) : Attachment

class VideoAttachment(override val type: String = "video", val video: Video = Video(duration = 30)) : Attachment
class ContentAttachment(override val type: String = "content", val content: Content = Content(1, 2, "new")) : Attachment

class AudioAttachment(override val type: String = "audio", val audio: Audio = Audio(title = "dance")) : Attachment

data class DocumentAttachment(
    override val type: String = "doc", val doc: Document = Document(
        1, 22,
        "important", 100
    )
) : Attachment


data class Audio(val id: Int = 2, val owner: Int = 22, val title: String)
data class Content(val id: Int, val owner: Int, val name: String)
data class Video(val id: Int = 10, val owner: Int = 100, val name: String = "null (:", val duration: Int)
data class Photo(val id: Int, val owner: Int, val name: String, val size: Int)
data class Document(val id: Int, val owner: Int, val name: String, val pageCount: Int)