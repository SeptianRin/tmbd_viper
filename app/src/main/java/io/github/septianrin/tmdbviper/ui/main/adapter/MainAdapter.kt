package io.github.septianrin.tmdbviper.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.septianrin.tmdbviper.R
import io.github.septianrin.tmdbviper.entity.Joke

class MainAdapter(private val jokes: List<Joke>, private val listener:UserListener): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    interface UserListener {
        fun onItemClick(joke:Joke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = jokes[position].name
        holder.desc.text = jokes[position].desc
        holder.site.text = jokes[position].site
        holder.itemView.setOnClickListener { listener.onItemClick(jokes[position]) }
    }

    override fun getItemCount(): Int {
       return jokes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val desc : TextView = itemView.findViewById(R.id.desc)
        val site : TextView = itemView.findViewById(R.id.site)
    }
}