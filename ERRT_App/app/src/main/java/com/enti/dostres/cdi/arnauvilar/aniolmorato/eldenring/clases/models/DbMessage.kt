package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.models

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class DbMessage(
    override var id: String? = null,
    var userId: String? = null,
    var message: String? = null,
    var imageUrl: String? = null,
    @ServerTimestamp var createDate: Date? = null

    ) : DbBaseData {

    override fun getTable() = "Messages"
}
