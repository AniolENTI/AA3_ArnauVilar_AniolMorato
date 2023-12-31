package com.enti.dostres.cdi.arnauvilar.blocfirebase.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enti.dostres.cdi.arnauvilar.blocfirebase.R
import com.enti.dostres.cdi.arnauvilar.blocfirebase.clases.firebase.FB

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.main_activity_screen);

        setTheme(FB.remoteConfig.getTheme().themeId)

    }

}