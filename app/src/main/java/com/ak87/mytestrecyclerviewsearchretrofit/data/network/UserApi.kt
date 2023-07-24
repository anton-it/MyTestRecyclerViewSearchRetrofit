package com.ak87.mytestrecyclerviewsearchretrofit.data.network

import com.ak87.mytestrecyclerviewsearchretrofit.domain.UsersModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("users")
    suspend fun getUsersList(): UsersModelList

    @GET("users/search")
    suspend fun getUsersByName(@Query("q") name: String): UsersModelList
}