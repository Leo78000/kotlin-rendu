package martin.leonard.mylist

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import martin.leonard.mylist.model.Posts
import martin.leonard.mylist.model.Users

class PostActivity : AppCompatActivity() {

    lateinit var posts: Posts
    lateinit var author : Users


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_text -> {

                val textFragment = TextFragment()
                val bundle = Bundle()
                bundle.putString("text", posts.body)
                textFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, textFragment)
                    .commit()

            }
            R.id.navigation_comments -> {


                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, CommentFragment())
                    .commit()


            }
            R.id.navigation_author -> {
                val authorFragment = AuthorFragment()
                val bundle = Bundle()
                bundle.putSerializable("author", author)
                authorFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, authorFragment)
                    .commit()

            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        val textFragment = TextFragment()
        val bundle = Bundle()
        posts = intent.getSerializableExtra("post") as Posts
        author = intent.getSerializableExtra("author") as Users
        bundle.putString("text",posts.body)
        textFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, textFragment)
            .commit()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
