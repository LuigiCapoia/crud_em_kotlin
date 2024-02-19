package com.example.crud_222.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_222.R
import com.example.crud_222.model.User

class ListAdapter(private val editClickListener: OnEditClickListener) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.textView).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.textView2).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.textView3).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.textView4).text = currentItem.age.toString()

        // Clique no botão de editar
        holder.itemView.findViewById<Button>(R.id.editButton).setOnClickListener {
            editClickListener.onEditClick(currentItem)
        }
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

    // Interface para manipular o clique no botão de editar
    interface OnEditClickListener {
        fun onEditClick(user: User)
    }
}
