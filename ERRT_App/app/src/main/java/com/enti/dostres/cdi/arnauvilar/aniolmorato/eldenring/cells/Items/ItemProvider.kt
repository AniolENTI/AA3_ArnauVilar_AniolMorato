package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories.ItemRepository

class ItemProvider(val repository: ItemRepository) {


suspend fun GetAllItems() : MutableList<ItemData> {
    return repository.GetItems()
}



}