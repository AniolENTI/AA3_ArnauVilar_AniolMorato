package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase

import android.app.Application

typealias FB = MyFirebase

class MyFirebase {

    companion object {

        lateinit var analytics: MyFirebaseAnalytics
        val crashlytics = MyCrashlytics()
        lateinit var auth: MyFirebaseAuth
        val db = MyFirebaseDatabase()
        val storage = MyFirebaseStorage()
        val remoteConfig = MyFirebaseRemoteConfig()

        fun init(appContext: Application)
        {
            analytics = MyFirebaseAnalytics(appContext)
            auth = MyFirebaseAuth(appContext)
        }
    }
}