package com.example.prakt

import android.content.Context

class DataManager(val baseContext: Context)  {
    val api = Api.createApi()
    val shared = baseContext.getSharedPreferences("Cash", Context.MODE_PRIVATE)

    fun getFio() : String = shared.getString("fio", "").toString()
    fun setFio(fio : String) = shared.edit().putString("fio", fio).apply()
    fun getNumOfStudent() : String = shared.getString("NumOfStudent", "").toString()
    fun setNumOfStudent(NumOfStudent : String) = shared.edit().putString("NumOfStudent", NumOfStudent).apply()

}