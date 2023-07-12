package com.ak87.mytestrecyclerviewsearchretrofit.domain

data class UserModel(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: Int,
    val token: String
)
