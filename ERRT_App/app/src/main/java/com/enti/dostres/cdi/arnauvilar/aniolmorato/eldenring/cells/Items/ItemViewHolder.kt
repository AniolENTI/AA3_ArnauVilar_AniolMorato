package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class ItemViewHolder(view: View) : ViewHolder(view) {
    val name by lazy { view.findViewById<TextView>(R.id.item_cell_title) }
    val description by lazy { view.findViewById<TextView>(R.id.item_cell_description) }
    val image by lazy { view.findViewById<ImageView>(R.id.item_cell_image) }

    fun SetupWith(item: ItemData) {
        name.text = item.name
        description.text = item.description

        item.image?.let { imageUrl ->

            //Placeholder
            CoroutineScope(Dispatchers.IO).launch {

                val stream = URL(imageUrl).openStream()
                val bitMap = BitmapFactory.decodeStream(stream)

                CoroutineScope(Dispatchers.Main).launch {
                    image.setImageBitmap(bitMap)
                    image.visibility = View.VISIBLE
                }
            }

        }
    }
}