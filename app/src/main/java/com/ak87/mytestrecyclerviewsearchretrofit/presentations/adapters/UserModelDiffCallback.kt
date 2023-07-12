package com.ak87.mytestrecyclerviewsearchretrofit.presentations.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ak87.mytestrecyclerviewsearchretrofit.domain.UserModel

object UserModelDiffCallback : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}