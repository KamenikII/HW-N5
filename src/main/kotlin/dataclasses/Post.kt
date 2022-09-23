package dataclasses

data class Post (
    val id: Int = 0, //ID поста
    val fromId: Int, //ID автора
    val date: Int, //время публикации
    val likes: Int = 0, //лайки
    val postType: String, //post copy reply, postpone, suggest
    val canPin: Boolean = true, //можно ли закреплять [true(да) false(нет)]
    val canEdit: Boolean = true, //можно ли изменять [true(да) false(нет)]
    val markedAsAds: Boolean = false, //это реклама [true(да) false(нет)]
    val friendsOnly: Boolean = false, // только для друзей [true(да) false(нет)]
    val isPinned: Boolean = false, //закреплено[true(да) false(нет)]

    //text
    val content: String, //текст поста

    //objects
    val comments: Comments = Comments, //Комментарии
)

object Comments {
    private var count: Int = 0 //кол-во комментариев
    private var canPost: Boolean = true // может ли пользователь выкладывать комментарий [true(да) false(нет)]

    fun addCount() {
       count+=1
    }

    @Override
    override fun toString(): String {
        return "${count}"
    }

    fun setCanPost(canPost: Boolean) {
        this.canPost = canPost
    }
}
