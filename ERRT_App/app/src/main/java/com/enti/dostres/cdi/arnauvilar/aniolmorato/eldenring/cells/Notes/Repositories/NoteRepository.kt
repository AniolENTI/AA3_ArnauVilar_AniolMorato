package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Achievements.Repositories

import ItemData

interface NoteRepository {
    suspend fun GetNotes() : MutableList<ItemData>
}