package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.models

interface DbBaseData {
    var id: String?

    fun getTable(): String
}