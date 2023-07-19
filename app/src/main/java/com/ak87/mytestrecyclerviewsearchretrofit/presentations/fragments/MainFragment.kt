package com.ak87.mytestrecyclerviewsearchretrofit.presentations.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak87.mytestrecyclerviewsearchretrofit.data.network.UserApi
import com.ak87.mytestrecyclerviewsearchretrofit.databinding.FragmentMainBinding
import com.ak87.mytestrecyclerviewsearchretrofit.presentations.MainViewModel
import com.ak87.mytestrecyclerviewsearchretrofit.presentations.adapters.UserModelAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: UserModelAdapter
    private lateinit var viewModel: MainViewModel
    //private var usersListRetrofit: UsersListModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initRecyclerView()
        //initRetrofit()
        updateUsersList()

        viewModel.liveDataUsersList.observe(viewLifecycleOwner) {
            //adapter.submitList(usersListRetrofit?.usersList)
        }
    }

    private fun initRecyclerView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = UserModelAdapter()
        rcView.adapter = adapter
        //val usersList = addDataToUsersList()
        //Log.d("MyLog111", usersList.toString())
        //adapter.submitList(usersList)
    }

//    private fun initRetrofit() {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .client(client)
//            .baseUrl("https://dummyjson.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val userModelApi = retrofit.create(UserModelApi::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val usersListRetrofit =  userModelApi.getUsersList()
//
//            Log.d("MyLog111", usersListRetrofit.usersList.toString())
//            adapter.submitList(usersListRetrofit.usersList)
//        }
//    }

    private fun updateUsersList() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val userApi = retrofit.create(UserApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val list = userApi.getUsersList()
            Log.d("MyLog111", "usersListTemp11 = ${list.users}")

//            binding.apply {
//                adapter.submitList(list.users)
//            }
        }
    }

//    private fun addDataToUsersList(): List<UserModel> {
//
//        val list = listOf<UserModel>(
//            UserModel(
//                1, "Dan", "", "", "",
//                "", R.drawable.java, ""
//            ),
//            UserModel(
//                2, "Ban", "", "", "",
//                "", R.drawable.cplusplus, ""
//            ),
//            UserModel(
//                3, "Jon", "", "", "",
//                "", R.drawable.csharp, ""
//            ),
//            UserModel(
//                4, "Sam", "", "", "",
//                "", R.drawable.javascript, ""
//            ),
//            UserModel(
//                5, "Martin", "", "", "",
//                "", R.drawable.kotlin, ""
//            ),
//            UserModel(
//                6, "Barn", "", "", "",
//                "", R.drawable.python, ""
//            ),
//            UserModel(
//                7, "Swen", "", "", "",
//                "", R.drawable.swift, ""
//            ),
//        )
//        return list
//
//    }

    companion object {
        fun newInstance() = MainFragment()
    }
}