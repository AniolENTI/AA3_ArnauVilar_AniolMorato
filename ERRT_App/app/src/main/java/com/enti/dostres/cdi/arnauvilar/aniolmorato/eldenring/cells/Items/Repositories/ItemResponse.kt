package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemData
import com.google.gson.annotations.SerializedName

data class ItemResponse(val itemData: ItemResponseData)

data class ItemResponseData(val count: Int, val total: Int, @SerializedName("data") val itemList: MutableList<ItemData>)
