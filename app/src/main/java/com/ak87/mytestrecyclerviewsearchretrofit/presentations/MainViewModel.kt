package com.ak87.mytestrecyclerviewsearchretrofit.presentations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ak87.mytestrecyclerviewsearchretrofit.domain.UserModel
import com.ak87.mytestrecyclerviewsearchretrofit.domain.UsersModelList

class MainViewModel : ViewModel() {
    val liveDataUsersList = MutableLiveData<List<UserModel>> ()
}