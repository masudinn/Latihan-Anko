package com.masudinn.kade1.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masudinn.kade1.model.LigaModel
import kotlinx.android.synthetic.main.item_liga.view.*

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bindItem(item: LigaModel, listener: (LigaModel) -> Unit) {
        itemView.name.text = item.name
        Glide.with(itemView.context).load(item.image).into(itemView.image)

        itemView.setOnClickListener {
            listener(item)
        }
    }
}