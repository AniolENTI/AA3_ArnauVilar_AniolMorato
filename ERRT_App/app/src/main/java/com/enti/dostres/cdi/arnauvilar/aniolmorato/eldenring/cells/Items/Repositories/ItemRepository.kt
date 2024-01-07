package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories

import ItemData

interface ItemRepository {
    suspend fun GetItems() : MutableList<ItemData>
}