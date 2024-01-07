package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemData
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.utils.Shared

class ItemSharedDatabase : ItemRepository {

    override suspend fun GetItems(): MutableList<ItemData> {
        return Shared.Items
    }
}