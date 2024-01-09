package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories.AchievementData
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories.AchievementRepository

class AchievementProvider(val repository: AchievementRepository) {

    suspend fun GetAllAchievements() : MutableList<AchievementData> {
        return repository.GetAchievements()
    }

}