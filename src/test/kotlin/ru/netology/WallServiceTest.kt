package ru.netology

import Comment
import Comments
import Geo
import Likes
import Post
import PostNotFoundException
import WallService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(
            Post(
                1,
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
        val update = Post(
            1,
            2,
            "Hello",
            "Text",
            2,
            2,
            3,
            canPin = true,
            canEdit = true,
            comments = Comments(1, false),
            likes = Likes(1, usersLike = false, canLike = false, canPublish = false),
            isFavorite = true,
            postponedId = 1,
            markedAsAds = 1,
            canDelete = false,
            signerId = 1,
            copyHistory = emptyArray(),
            repost = null,
            replyPostId = 1,
            friendsOnly = true,
            replyOwnerId = 3,
            geo = Geo("Geo", "65.13.22", null),
            copyright = null
        )
        val result = service.upDate(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(
            Post(
                1,
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
        val update = Post(
            2,
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
        val result = service.upDate(update)
        assertFalse(result)
    }

    @Test
    fun addPost() {
        val service = WallService
        val result = service.add(
            Post(
                1,
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
        assertEquals(1, result.id)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        service.add(
            Post(
                1,
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
        service.add(
            Post(
                2,
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
        service.createComment(3, Comment(1, 1, 2, "Hello"))

    }

    @Test
    fun shouldNotThrow() {
        val service = WallService
        val post = Post(
            1,
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
        service.add(post)

        val comment = Comment(
            1,
            1,
            11,
            "test"
        )
        service.createComment(1, comment)

        assertEquals(1, service.comments.size)
        assertEquals(comment, service.comments.last())
    }
}
