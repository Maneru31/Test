package com.example.prakt

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("check_student.php")
    fun checkStudent(@Query("f") f : String,
        @Query("i") i: String,
        @Query("o") o: String,
        @Query("group") group : String,
        @Query("permission") permission : String = "*W7a^!pH5WVz7XwjS-6ZaqdBsRNfRQjFwz5mtpURte*7x^WcK8") : Observable<String>

    @POST("create_request.php")
    fun request(@Query("f") f : String,
                @Query("i") i: String,
                @Query("o") o: String,
                @Query("group") group : String,
                @Query("count") count : Int,
                @Query("permission") permission: String = "*W7a^!pH5WVz7XwjS-6ZaqdBsRNfRQjFwz5mtpURte*7x^WcK8") : Observable<String>

    companion object {
        fun createApi() : Api{
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://креатив256.рф/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                return retrofit.create(Api::class.java)
        }
    }
}