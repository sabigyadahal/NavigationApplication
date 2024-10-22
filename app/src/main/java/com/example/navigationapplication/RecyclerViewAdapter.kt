package com.example.NavigationApplication.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.NavigationApplication.Entity
import com.example.navigationapplication.R


class EntityAdapter(private val onClick: (Entity) -> Unit) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    private var entityList = listOf<Entity>()

    fun submitList(list: List<Entity>) {
        entityList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(entityList[position])
    }

    override fun getItemCount(): Int = entityList.size

    inner class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(entity: Entity) {
            val property1TextView: TextView = itemView.findViewById(R.id.property1_TextView)
            val property2TextView: TextView = itemView.findViewById(R.id.property2TextView)

            property1TextView.text = entity.property1
            property2TextView.text = entity.property2
            itemView.setOnClickListener { onClick(entity) }
        }
    }

}

