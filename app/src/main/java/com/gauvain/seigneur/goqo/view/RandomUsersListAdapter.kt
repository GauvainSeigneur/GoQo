package com.gauvain.seigneur.goqo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.gauvain.seigneur.goqo.presentation.data.UserItemData

class RandomUsersListAdapter(
    private val listener: Listener) : PagedListAdapter<UserItemData, UserItemViewHolder>
    (DiffCallback) {

    interface Listener {
        fun onClick(
            id:String?
        )
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<UserItemData>() {
            override fun areItemsTheSame(oldItem: UserItemData, newItem: UserItemData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserItemData, newItem: UserItemData): Boolean {
                return oldItem.email == newItem.email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder =
        UserItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                UserItemViewHolder.layout,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

}
