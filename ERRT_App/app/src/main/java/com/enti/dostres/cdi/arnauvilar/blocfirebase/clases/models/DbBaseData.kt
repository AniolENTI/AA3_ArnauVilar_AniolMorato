package com.enti.dostres.cdi.arnauvilar.blocfirebase.clases.models

interface DbBaseData {
    var id: String?

    fun getTable(): String
}