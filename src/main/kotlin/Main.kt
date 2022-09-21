import dataclasses.Post

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val i: Int = posts.size
        post.id = i+1
        posts += post
        return posts.last()
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes+1)
            }
        }
    }

    fun update(post: Post): Boolean {
        for ((index, p) in posts.withIndex()) {
            if ((post.id == p.id) && (post.can_edit == p.can_edit)) {
                    posts[index] = p.copy(content = post.content)
                    return true
            }
        }
        return false
    }

    fun giveId(index: Int): Int {
        return(posts[index].id)
    }
}

class Main {
}
