package com.ralvez.myapplicationlayout02

object MyDataSingleton {
    var myDataList: MutableList<MyData> = mutableListOf()

}

data class MyData(val firstName: String, val lastName: String, val email: String, val password: String)

