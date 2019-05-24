package martin.leonard.mylist.model

import java.io.Serializable

data class Posts (
    var id: Int,
    var userId : Int,
    var title: String,
    var body: String
    ):Serializable