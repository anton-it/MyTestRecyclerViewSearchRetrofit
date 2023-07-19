package com.ak87.mytestrecyclerviewsearchretrofit.data.network

import com.ak87.mytestrecyclerviewsearchretrofit.domain.UsersModelList
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsersList(): UsersModelList
}