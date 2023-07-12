package com.ak87.mytestrecyclerviewsearchretrofit.presentations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val liveDataUsersList = MutableLiveData<String>()
}