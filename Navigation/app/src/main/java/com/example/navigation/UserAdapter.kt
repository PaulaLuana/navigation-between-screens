package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.model.User

class UserAdapter(private val users: MutableList<User>): RecyclerView.Adapter<UserAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
        return MessageViewHolder(item)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.item.text = "[Código: ${users[position].id}, ${users[position].nome}, ${users[position].email}]"
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val item: TextView = itemView.findViewById(R.id.item)
    }

}