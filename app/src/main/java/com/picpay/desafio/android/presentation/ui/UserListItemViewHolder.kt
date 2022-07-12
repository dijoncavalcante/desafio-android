package com.picpay.desafio.android.presentation.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListItemViewHolder(
    itemView: ListItemUserBinding
) : RecyclerView.ViewHolder(itemView.root) {

    fun bind(user: UserResponse) {
        itemView.name.text = user.name
        itemView.username.text = user.username
        itemView.progressBar.visibility = View.VISIBLE
        Picasso.get()
            .load(user.img)
            .error(R.drawable.ic_round_account_circle)
            .into(itemView.picture, object : Callback {
                override fun onSuccess() {
                    itemView.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    itemView.progressBar.visibility = View.GONE
                }
            })
    }
}