package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories.AchievementData

class AchievementAdapter(private val achievementList: List<AchievementData>) : RecyclerView.Adapter<AchievementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AchievementViewHolder(layoutInflater.inflate(R.layout.achievement_cell, parent, false))
    }

    override fun getItemCount(): Int {
        return achievementList.size
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        holder.SetupWith(achievementList[position])
    }
}