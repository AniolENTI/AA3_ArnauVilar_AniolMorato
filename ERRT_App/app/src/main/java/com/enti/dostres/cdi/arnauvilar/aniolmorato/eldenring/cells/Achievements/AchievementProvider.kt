import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Achievements.Repositories.AchievementRepository

class AchievementProvider(val repository: AchievementRepository) {


suspend fun GetAllAchievements() : MutableList<ItemData> {
    return repository.GetAchievements()
}



}