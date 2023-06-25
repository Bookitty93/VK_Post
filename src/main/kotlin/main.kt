fun main() {
    val comment = Comment(1, 1, 2, "hello")
    println(WallService.createComment(1, comment))
    println(
        WallService.add(
            Post(
                null,
                1,
                "Hi",
                "Text",
                1,
                1,
                2,
                canPin = true,
                canEdit = true,
                comments = Comments(1, false),
                likes = Likes(1, usersLike = false, canLike = false, canPublish = false),
                isFavorite = true,
                postponedId = 1,
                markedAsAds = 1,
                canDelete = true,
                signerId = 1,
                copyHistory = emptyArray(),
                repost = null,
                replyPostId = 1,
                friendsOnly = true,
                replyOwnerId = 3,
                geo = Geo("Geo", "65.13.22", null),
                copyright = null
            )
        )
    )
    println(
        WallService.upDate(
            Post(
                null,
                1,
                "Hi",
                "Text",
                1,
                1,
                2,
                canPin = true,
                canEdit = true,
                comments = Comments(1, false),
                likes = Likes(1, usersLike = false, canLike = false, canPublish = false),
                isFavorite = true,
                postponedId = 1,
                markedAsAds = 1,
                canDelete = true,
                signerId = 1,
                copyHistory = emptyArray(),
                repost = null,
                replyPostId = 1,
                friendsOnly = true,
                replyOwnerId = 3,
                geo = Geo("Geo", "65.13.22", null),
                copyright = null
            )
        )
    )

}

data class Post(
    val id: Int?,
    val date: Int,
    var text: String?,
    var postType: String,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val canPin: Boolean,
    val canEdit: Boolean,
    val comments: Comments = Comments(0, true),
    val likes: Likes = Likes(0, usersLike = true, canLike = true, canPublish = true),
    val isFavorite: Boolean,
    val postponedId: Int,
    val markedAsAds: Int,
    val canDelete: Boolean,
    val signerId: Int,
    val copyHistory: Array<Boolean>,
    val repost: Post?,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val replyOwnerId: Int,
    val geo: Geo,
    val copyright: Copyright?,
    val attachment: Array<Attachment> = arrayOf()
)

data class Likes(
    var count: Int,
    var usersLike: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Comments(
    var count: Int,
    val canPost: Boolean,
)

data class Geo(val type: String, val coordinates: String, val place: Place?)
class Place()
data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String
)

class PostNotFoundException(message: String) : RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
    private var id = 1
    fun add(post: Post): Post {
        val changePost = post.copy(id = id++)
        posts += changePost
        return posts.last()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in posts.withIndex()) {
            if (postId == post.id) {
                comments += comment
            }
            return comment
        }
        throw PostNotFoundException("Hет такого айди: $postId")
    }

    fun upDate(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                println(newPost)
                return true
            }
        }
        return false

    }

    fun clear() {
        posts = emptyArray()
        id = 1
    }
}

