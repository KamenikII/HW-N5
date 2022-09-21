import dataclasses.Post
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        // создаём целевой сервис
        val service = WallService
        val post = Post(from_id = 0, date = 0, post_type = "post", content = "test")
        // заполняем пост
        service.add(post)
        val result = (service.giveId(0) != 0)

        assertEquals(true, result)
    }

    @Test
    fun updateTrue() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test1"))
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test2"))
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test3"))
        // создаём информацию об обновлении
        val update = Post(id = 1, from_id = 0, date = 0, post_type = "post", content = "new")

        // выполняем целевое действие
        val result = service.update(update)
        assertEquals(true, result)
    }

    @Test
    fun updateFalse1() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test1"))
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test2"))
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test3"))
        // создаём информацию об обновлении
        val update = Post(id = 4, from_id = 0, date = 0, post_type = "post", content = "new")

        // выполняем целевое действие
        val result = service.update(update)
        assertEquals(false, result)
    }

    @Test
    fun updateFalse2() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test1", can_edit = false))
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test2"))
        service.add(Post(from_id = 0, date = 0, post_type = "post", content = "test3"))
        // создаём информацию об обновлении
        val update = Post(id = 0, from_id = 0, date = 0, post_type = "post", content = "new")

        // выполняем целевое действие
        val result = service.update(update)
        assertEquals(false, result)
    }
}