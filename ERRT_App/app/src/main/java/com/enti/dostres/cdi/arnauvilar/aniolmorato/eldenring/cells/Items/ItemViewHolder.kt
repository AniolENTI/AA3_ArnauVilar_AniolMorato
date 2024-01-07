package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R

class ItemViewHolder(view: View) : ViewHolder(view) {
    val name by lazy {view.findViewById<TextView>(R.id.item_cell_title)}
    val description by lazy {view.findViewById<TextView>(R.id.item_cell_description)}

    fun SetupWith(item: ItemData) {
        name.text = item.name
        description.text = item.description
    }
}