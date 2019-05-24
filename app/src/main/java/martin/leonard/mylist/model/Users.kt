package martin.leonard.mylist.model

import java.io.Serializable

data class Users (
    var id : Int,
    var name : String,
    var userId : Int,
    var email : String,
    var username : String
):Serializable
