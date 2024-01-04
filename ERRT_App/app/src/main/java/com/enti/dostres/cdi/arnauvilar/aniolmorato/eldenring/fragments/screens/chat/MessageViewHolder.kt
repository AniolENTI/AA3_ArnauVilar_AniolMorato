package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.screens.chat

import android.graphics.BitmapFactory
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase.FB
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.models.DbMessage
import com.google.android.material.textview.MaterialTextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val container by lazy { view.findViewById<LinearLayout>(R.id.message_container) }
    private val message by lazy { view.findViewById<MaterialTextView>(R.id.message_text) }
    private val image by lazy { view.findViewById<ImageView>(R.id.message_image) }

    fun setupWithMessage(dbMessage: DbMessage) {

        if(dbMessage.userId == FB.auth.getUser()?.id) {
            container.gravity = Gravity.RIGHT
        } else {
            container.gravity = Gravity.LEFT
        }

        dbMessage.message?.let { text ->
            message.text = text
            message.visibility = View.VISIBLE
        } ?: kotlin.run {
            message.visibility = View.GONE
        }

        dbMessage.imageUrl?.let {imageUrl ->

            //Placeholder
            CoroutineScope(Dispatchers.IO).launch {

                val stream = URL(imageUrl).openStream()
                val bitMap = BitmapFactory.decodeStream(stream)

                CoroutineScope(Dispatchers.Main).launch {
                    image.setImageBitmap(bitMap)
                    image.visibility = View.VISIBLE
                }
            }

        } ?: kotlin.run {
            image.visibility = View.GONE
        }

    }

}