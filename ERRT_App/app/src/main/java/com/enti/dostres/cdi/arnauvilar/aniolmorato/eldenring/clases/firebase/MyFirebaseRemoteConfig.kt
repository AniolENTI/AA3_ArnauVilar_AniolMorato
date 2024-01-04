package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class MyFirebaseRemoteConfig {
    private val remoteConfig = Firebase.remoteConfig

    enum class RemoteKeys(val key:String) {
        CurrentTheme("current_theme")
    }

    init {

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 30 // Low value for test, set greater value on production
        }

        remoteConfig.setConfigSettingsAsync(configSettings)

        //Add Default
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        remoteConfig.fetchAndActivate()
    }

    enum class AppTheme(val key:String, val themeId: Int) {
        Base("Base", R.style.Theme_BlocFireBase),
        Christmas("Christmas", R.style.Theme_BlocFireBase_Christmas);

        companion object {

            fun fromKey(key: String): AppTheme {
                return values().find { theme -> theme.key == key } ?: Base
            }
        }

    }

    fun getTheme(): AppTheme {
        val key = remoteConfig.getString(RemoteKeys.CurrentTheme.key)
        return AppTheme.fromKey(key)
    }

}