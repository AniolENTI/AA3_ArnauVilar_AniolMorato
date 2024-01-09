package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.achievements.Repositories

interface AchievementRepository {
    suspend fun GetAchievements() : MutableList<AchievementData>
}