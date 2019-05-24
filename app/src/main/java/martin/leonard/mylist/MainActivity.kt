package martin.leonard.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import martin.leonard.mylist.model.Posts
import martin.leonard.mylist.model.Users
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter()
        recyclerView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create<API>()

        api.getPosts().enqueue(object : Callback<List<Posts>>{
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Log.e("DL", "Download Failed: ${t.message}")
            }

            override fun onResponse(call : Call<List<Posts>>, response : Response<List<Posts>>){
                val posts = response.body()!!
                api.getUsers().enqueue(object : Callback<List<Users>>{
                    override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                        Log.e("DL", "Download failed : ${t.message}")
                    }

                    override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                        val users = response.body()!!


                        adapter.list = posts
                        adapter.list2 = users
                        adapter.notifyDataSetChanged()
                    }
                })
            }
        })
    }
}











