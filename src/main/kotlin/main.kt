fun main() {
    println(
        WallService.add(
            Post(
                1,
                1,
                "Hi",
                "Test",
                1,
                1,
                1,
                canPin = true,
                canEdit = true,
                comments = Comments(count = 0, canPost = true),
                likes = Likes(count = 0, usersLike = true, canLike = true, canPublish = true)
            )
        )
    )
    println(
        WallService.upDate(
            Post(
                1,
                2,
                "Hello",
                "Test2",
                2,
                2,
                2,
                canPin = false,
                canEdit = false,
                comments = Comments(count = 1, canPost = false),
                likes = Likes(count = 1, usersLike = false, canLike = false, canPublish = false)
            )
        )
    )

}

data class Post(
    val id: Int,
    val date: Int,
    var text: String,
    var postType: String,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val canPin: Boolean,
    val canEdit: Boolean,
    val comments: Comments = Comments(0, true),
    val likes: Likes = Likes(0, usersLike = true, canLike = true, canPublish = true)
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

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 1
    fun add(post: Post): Post {
        val changePost = post.copy(id = id++)
        posts += changePost
        return posts.last()
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

