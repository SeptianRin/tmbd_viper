package io.github.septianrin.tmdbviper.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.septianrin.tmdbviper.R
import io.github.septianrin.tmdbviper.entity.User

class MainAdapter(private val users: List<User>, private val listener:UserListener): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    interface UserListener {
        fun onItemClick(user:User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = users[position].firstName
        holder.desc.text = users[position].lastName
        holder.site.text = users[position].id.toString()
        holder.itemView.setOnClickListener { listener.onItemClick(users[position]) }
    }

    override fun getItemCount(): Int {
       return users.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val desc : TextView = itemView.findViewById(R.id.desc)
        val site : TextView = itemView.findViewById(R.id.site)
    }
}