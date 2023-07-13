package com.ak87.mytestrecyclerviewsearchretrofit.presentations.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.ak87.mytestrecyclerviewsearchretrofit.R
import com.ak87.mytestrecyclerviewsearchretrofit.data.network.UserModelApi
import com.ak87.mytestrecyclerviewsearchretrofit.databinding.FragmentMainBinding
import com.ak87.mytestrecyclerviewsearchretrofit.domain.UserModel
import com.ak87.mytestrecyclerviewsearchretrofit.presentations.adapters.UserModelAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.userAgent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: UserModelAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val userModelApi = retrofit.create(UserModelApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
           val usersListRetrofit =  userModelApi.getUsersList()
            Log.d("MyLog111", usersListRetrofit.toString())
        }
    }

    private fun initRecyclerView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = UserModelAdapter()
        rcView.adapter = adapter
        val usersList = addDataToUsersList()
        Log.d("MyLog111", usersList.toString())
        adapter.submitList(usersList)
    }

    private fun addDataToUsersList(): List<UserModel>{

        val list = listOf<UserModel>(
            UserModel(1, "Dan", "", "", "",
                "", R.drawable.java, ""),
            UserModel(2, "Ban", "", "", "",
                "", R.drawable.cplusplus, ""),
            UserModel(3, "Jon", "", "", "",
                "", R.drawable.csharp, ""),
            UserModel(4, "Sam", "", "", "",
                "", R.drawable.javascript, ""),
            UserModel(5, "Martin", "", "", "",
                "", R.drawable.kotlin, ""),
            UserModel(6, "Barn", "", "", "",
                "", R.drawable.python, ""),
            UserModel(7, "Swen", "", "", "",
                "", R.drawable.swift, ""),
        )
        return list

    }

    companion object {
        fun newInstance() = MainFragment()
    }
}