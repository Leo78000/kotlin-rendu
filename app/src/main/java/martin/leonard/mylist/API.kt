package martin.leonard.mylist

import martin.leonard.mylist.model.Posts
import martin.leonard.mylist.model.Users
import retrofit2.Call
import retrofit2.http.GET


interface API {

    @GET("/posts")
    fun getPosts(): Call<List<Posts>>

    @GET("/users")
    fun getUsers(): Call<List<Users>>
}