package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories.AchievementData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class AchievementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name by lazy { view.findViewById<TextView>(R.id.achievement_cell_title) }
    val description by lazy { view.findViewById<TextView>(R.id.achievement_cell_description) }
    val image by lazy { view.findViewById<ImageView>(R.id.achievement_cell_image) }

    fun SetupWith(achievement: AchievementData) {
        name.text = achievement.name
        description.text = achievement.description

    }
}