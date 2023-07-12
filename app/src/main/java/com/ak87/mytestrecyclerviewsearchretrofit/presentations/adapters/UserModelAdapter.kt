package com.ak87.mytestrecyclerviewsearchretrofit.presentations.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ak87.mytestrecyclerviewsearchretrofit.databinding.UserItemBinding
import com.ak87.mytestrecyclerviewsearchretrofit.domain.UserModel

class UserModelAdapter : ListAdapter<UserModel, UserModelAdapter.ViewHolder>(UserModelDiffCallback) {

    class ViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

//        fun bind(item: UserModel) = with(binding) {
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            tvUserName.text = item.firstName
            ivLogo.setImageResource(item.image.toInt())
        }

    }
}