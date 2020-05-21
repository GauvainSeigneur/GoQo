package com.gauvain.seigneur.goqo.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gauvain.seigneur.goqo.R
import com.gauvain.seigneur.goqo.presentation.data.UserItemData
import kotlinx.android.synthetic.main.item_user.view.*

class UserItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        val layout = R.layout.item_user
    }

    fun bind(itemData: UserItemData?, listener: RandomUsersListAdapter.Listener) {
        with(itemView) {
            userName.text = itemData?.name?.getFormattedString(itemView.context)
            userEmail.text = itemData?.email

            userItemView.setOnClickListener {
                listener.onClick(itemData?.id)
            }
        }
    }

}