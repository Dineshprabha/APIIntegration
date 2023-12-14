package com.dineshprabha.apiintegration

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    //without coroutines
    @GET("comments")
    fun getComments(): Call<List<Comments>>


    //using coroutines handling api
    @GET("comments")
    suspend fun getAllComments(): Response<List<Comments>>

}