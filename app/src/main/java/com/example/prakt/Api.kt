package com.example.prakt

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("auth_mobile_app.php")
    fun checkStudent(
            @Query("studentFIO") studentFIO: String,
            @Query("numOfStudent") numOfStudent: String,
            @Query("token") token: String = "DJGrB5clgrQ370wfQtTUoe0yNZEO5dcNnsanEZy9Fbyx8yrqn3OUrltnieE182E8oQ318RQHl3fz9wtjsfvL7etZueveurgzSpSQLXH4PnJgjqLRJFjZBwxwUSRToZ9c"
                     ) : Observable<String>

    @POST("create_request.php")
        fun request(
            @Query("studentFIO") studentFIO: String,
            @Query("countOfRequests") countRequest: String,
            @Query("dateOfSending") dateOfSending : String,
            @Query("addressOfThePoint") addressOfThePoint : String,
            @Query("token") token: String = "DJGrB5clgrQ370wfQtTUoe0yNZEO5dcNnsanEZy9Fbyx8yrqn3OUrltnieE182E8oQ318RQHl3fz9wtjsfvL7etZueveurgzSpSQLXH4PnJgjqLRJFjZBwxwUSRToZ9c"

    ): Observable<String>

    companion object {
        fun createApi() : Api{
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://ktkknity.online/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                return retrofit.create(Api::class.java)
        }
    }
}