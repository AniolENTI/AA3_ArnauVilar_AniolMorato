package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemData
import com.google.gson.annotations.SerializedName

data class ItemResponse(val code: Int, @SerializedName("data") val itemData: ItemResponseData)

data class ItemResponseData(val offset: Int, val count: Int, val total: Int, @SerializedName("results") val itemList: MutableList<ItemData>)
