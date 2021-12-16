package com.example.clonegrab.model

data class DataModel (
    var id: Int = getAutoID(),
    var name: String = "",
    var game: String = "",
    var email: String = ""
){
    companion object{
        fun getAutoID():Int{
            val random = java.util.Random()
            return random.nextInt(100)
        }
    }
}