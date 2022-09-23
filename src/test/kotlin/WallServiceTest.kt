import dataclasses.Post
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        // создаём целевой сервис
        val service = WallService
        val post = Post(fromId = 0, date = 0, postType = "post", content = "test")
        // заполняем пост
        service.add(post)
        val result = (service.giveId(0) != 0)

        assertTrue(result)
    }

    @Test
    fun updateTrue() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test1"))
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test2"))
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test3"))
        // создаём информацию об обновлении
        val update = Post(id = 1, fromId = 0, date = 0, postType = "post", content = "new")

        // выполняем целевое действие
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateFalse1() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test1"))
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test2"))
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test3"))
        // создаём информацию об обновлении
        val update = Post(id = 4, fromId = 0, date = 0, postType = "post", content = "new")

        // выполняем целевое действие
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun updateFalse2() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test1", canEdit = false))
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test2"))
        service.add(Post(fromId = 0, date = 0, postType = "post", content = "test3"))
        // создаём информацию об обновлении
        val update = Post(id = 0, fromId = 0, date = 0, postType = "post", content = "new")

        // выполняем целевое действие
        val result = service.update(update)
        assertFalse(result)
    }
}