fun main() {
    println(WallService.add(Post(1, 1, "Hi", "Test", 1, 1, 1, canPin = true, canEdit = true)))
    println(WallService.upDate(Post(1, 2, "Hello", "tesst2", 2, 2, 2, canPin = false, canEdit = false)))
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
    val canEdit: Boolean
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
        posts += post
        return posts.last()
    }

    fun upDate(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(text = post.text)
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

