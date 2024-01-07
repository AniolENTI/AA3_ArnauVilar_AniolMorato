package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.utils

import android.content.Context
import android.content.SharedPreferences
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemData
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.MyApp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

typealias Shared = SharedPreferencesManager

object SharedPreferencesManager {
    private const val MyPreferencesName = "MySharedPreferencesStorage"

    private val shared: SharedPreferences by lazy { MyApp.Context.getSharedPreferences(MyPreferencesName, Context.MODE_PRIVATE) }
    private val editor: SharedPreferences.Editor by lazy { shared.edit() }

    private const val TimesOpenAppKey = "AppOpenTimes"
    public var TimesOpenApp: Int
        get() = shared.getInt(TimesOpenAppKey, 0)
        set(value) {
            editor.putInt(TimesOpenAppKey, value)
            editor.apply()
        }

    private const val ItemsKey = "Items"
    public var Items: MutableList<ItemData>
        get() {
            val jsonString = shared.getString(ItemsKey, "")
            val listType = object : TypeToken<MutableList<ItemData>?>() {}.type
            val itemList: MutableList<ItemData>? = Gson().fromJson(jsonString, listType)
            return itemList ?: mutableListOf()
        }
        set(value) {
            val jsonString = Gson().toJson(value)
            editor.putString(ItemsKey,jsonString)
            editor.apply()
        }
}