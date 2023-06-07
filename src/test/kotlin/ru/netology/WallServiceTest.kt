package ru.netology

import Post
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
        service.add(Post(1, 1, "Hi", "Test", 1, 1, 1, canPin = true, canEdit = true))
        val update = Post(1, 2, "Hello", "tesst2", 2, 2, 2, canPin = false, canEdit = false)
        val result = service.upDate(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(Post(1, 1, "Hi", "Test", 1, 1, 1, canPin = true, canEdit = true))
        val update = Post(3, 1, "Hi", "Test", 1, 1, 1, canPin = true, canEdit = true)
        val result = service.upDate(update)
        assertFalse(result)
    }

    @Test
    fun addPost() {
        val service = WallService
        val result = service.add(
            Post(1, 1, "Hi", "Test", 1, 1, 1, canPin = true, canEdit = true)
        )
        assertEquals(1, result.id)
    }
}