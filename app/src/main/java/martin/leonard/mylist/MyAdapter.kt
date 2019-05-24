package martin.leonard.mylist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell.view.*
import martin.leonard.mylist.model.Posts
import martin.leonard.mylist.model.Users


class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    var list : List<Posts> = emptyList()
    var list2 : List<Users> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell, parent,false)
        return ViewHolder(view)
    }




    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {

        val item: Posts = list[position]
        holder.itemView.cellname2.text =list2.first{ it.id ==item.userId}.name
        holder.itemView.cellName.text = item.title
        holder.itemView.setOnClickListener{
            val intent = Intent (holder.itemView.context,PostActivity::class.java)
            intent.putExtra("post",item)
            intent.putExtra("author", list2.first{it.id == item.userId})
            holder.itemView.context.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}