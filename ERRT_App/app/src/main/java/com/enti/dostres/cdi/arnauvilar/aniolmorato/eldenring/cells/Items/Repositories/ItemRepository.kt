package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Achievements.Repositories

import ItemData

interface ItemRepository {
    suspend fun GetItems() : MutableList<ItemData>
}