package com.ak87.mytestrecyclerviewsearchretrofit.presentations.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak87.mytestrecyclerviewsearchretrofit.data.network.ApiFactory
import com.ak87.mytestrecyclerviewsearchretrofit.databinding.FragmentMainBinding
import com.ak87.mytestrecyclerviewsearchretrofit.domain.UserModel
import com.ak87.mytestrecyclerviewsearchretrofit.presentations.MainViewModel
import com.ak87.mytestrecyclerviewsearchretrofit.presentations.adapters.UserModelAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: UserModelAdapter
    private lateinit var viewModel: MainViewModel
    private var usersList: List<UserModel>? = null
    private val userApi = ApiFactory.userApi

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
        getUsersListData()
        updateUsersList()
    }

    private fun initRecyclerView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = UserModelAdapter()
        rcView.adapter = adapter
    }


    private fun getUsersListData() {
        CoroutineScope(Dispatchers.IO).launch {
            val list = userApi.getUsersList()
            usersList = list.users
            Log.d("MyLog111", "usersListTemp11 = $usersList")
            viewModel.liveDataUsersList.postValue(usersList)
        }
    }

    private fun updateUsersList() = with(binding) {
        viewModel.liveDataUsersList.observe(viewLifecycleOwner) {
            adapter.submitList(usersList)
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}