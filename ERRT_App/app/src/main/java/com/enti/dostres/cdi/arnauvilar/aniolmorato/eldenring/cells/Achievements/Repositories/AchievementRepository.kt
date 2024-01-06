package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Achievements.Repositories

import ItemData

interface AchievementRepository {
    suspend fun GetAchievements() : MutableList<ItemData>
}