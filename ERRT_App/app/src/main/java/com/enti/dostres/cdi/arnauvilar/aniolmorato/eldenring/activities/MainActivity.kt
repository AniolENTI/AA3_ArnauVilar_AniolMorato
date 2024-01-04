package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase.FB

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.main_activity_screen)

        setTheme(FB.remoteConfig.getTheme().themeId)

    }

}