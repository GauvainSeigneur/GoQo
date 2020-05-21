package com.gauvain.seigneur.goqo.view.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gauvain.seigneur.goqo.R
import com.gauvain.seigneur.goqo.presentation.data.UserItemData
import com.gauvain.seigneur.goqo.view.main.RandomUsersListAdapter
import kotlinx.android.synthetic.main.item_user.view.*

class UserItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        val layout = R.layout.item_user
    }

    fun bind(itemData: UserItemData?, listener: RandomUsersListAdapter.Listener) {
        with(itemView) {
            userName.text = "${itemData?.firstName} ${itemData?.lastName}"
            userEmail.text = itemData?.email

            userItemView.setOnClickListener {
                listener.onClick(itemData)
            }
        }
    }

}