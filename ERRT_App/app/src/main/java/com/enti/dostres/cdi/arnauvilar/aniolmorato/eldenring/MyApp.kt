package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring

import android.app.Activity
import android.app.Application
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase.FB
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase.MyFirebase

class MyApp: Application() {

    companion object {
        private lateinit var instance: MyApp

        public val Context: MyApp get() = instance
        fun get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        FB.init(this)
        FB.analytics.logOpenApp()
    }

    fun closeKeyboard(focusedView: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(focusedView.windowToken, 0)
    }
}