package com.ak87.mytestrecyclerviewsearchretrofit.data.network

import com.ak87.mytestrecyclerviewsearchretrofit.domain.UserModel
import retrofit2.http.GET

interface UserModelApi {
    @GET("/users")
    suspend fun getUsersList(): UserModel
}