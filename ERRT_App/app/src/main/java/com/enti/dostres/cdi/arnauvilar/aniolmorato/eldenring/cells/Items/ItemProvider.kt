import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Achievements.Repositories.ItemRepository

class ItemProvider(val repository: ItemRepository) {


suspend fun GetAllItems() : MutableList<ItemData> {
    return repository.GetItems()
}



}