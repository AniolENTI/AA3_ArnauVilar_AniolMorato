package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.screens

import AchievementMockRepository
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.AchievementAdapter
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.AchievementProvider
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.components.AppTopBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AchievementsScreen : Fragment() {

    private lateinit var table: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_achievements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        table = view.findViewById(R.id.my_achievements_table)
        table.layoutManager = LinearLayoutManager(requireContext())

        val repository = AchievementMockRepository()
        val provider = AchievementProvider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val achievements = provider.GetAllAchievements()

            CoroutineScope(Dispatchers.Main).launch {

                table.adapter = AchievementAdapter(achievements)
            }
        }
    }
}