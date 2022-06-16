package com.example.prakt

import android.content.Context

class DataManager(val baseContext: Context)  {
    val api = Api.createApi()
    val shared = baseContext.getSharedPreferences("Cash", Context.MODE_PRIVATE)

    fun getFam() : String = shared.getString("fam", "").toString()
    fun setFam(fam : String) = shared.edit().putString("fam", fam).apply()
    fun getName() : String = shared.getString("name", "").toString()
    fun setName(name : String) = shared.edit().putString("name", name).apply()
    fun getOtche() : String = shared.getString("otche", "").toString()
    fun setOtche(otche : String) = shared.edit().putString("otche", otche).apply()
    fun getGroup() : String = shared.getString("group", "").toString()
    fun setGroup(group : String) = shared.edit().putString("group", group).apply()

}