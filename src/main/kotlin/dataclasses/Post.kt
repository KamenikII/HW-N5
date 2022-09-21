package dataclasses

data class Post (
    var id: Int = 0, //ID поста
    val from_id: Int, //ID автора
    val date: Int, //время публикации
    var likes: Int = 0, //лайки
    val post_type: String, //post copy reply, postpone, suggest
    val can_pin: Boolean = true, //можно ли закреплять [true(да) false(нет)]
    val can_edit: Boolean = true, //можно ли изменять [true(да) false(нет)]
    val marked_as_ads: Boolean = false, //это реклама [true(да) false(нет)]
    val friends_only: Boolean = false, // только для друзей [true(да) false(нет)]
    val is_pinned: Boolean = false, //закреплено[true(да) false(нет)]

    //text
    var content: String, //текст поста

    //objects
    var comments: Comments = Comments, //Комментарии
)

object Comments {
    private var count: Int = 0 //кол-во комментариев
    private var can_post: Boolean = true // может ли пользователь выкладывать комментарий [true(да) false(нет)]

    fun addCount() {
       count+=1
    }

    @Override
    override fun toString(): String {
        return "${count}"
    }

    fun setCanPost(can_post: Boolean) {
        this.can_post = can_post
    }
}
