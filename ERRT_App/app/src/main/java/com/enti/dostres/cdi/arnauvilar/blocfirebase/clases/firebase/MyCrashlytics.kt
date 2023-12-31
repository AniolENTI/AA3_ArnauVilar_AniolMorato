package com.enti.dostres.cdi.arnauvilar.blocfirebase.clases.firebase

import com.google.firebase.Firebase
import com.google.firebase.crashlytics.KeyValueBuilder
import com.google.firebase.crashlytics.crashlytics
import com.google.firebase.crashlytics.setCustomKeys
import java.lang.Exception
import kotlin.math.log

class MyCrashlytics {
    private val crashlytics = Firebase.crashlytics

    fun logSimpleError(text: String, addExtraDataLambda: (KeyValueBuilder.() -> Unit)? = null) {
        logError(Exception(text), addExtraDataLambda)
    }

    fun logError(exception: Exception, addExtraDataLambda: (KeyValueBuilder.() -> Unit)? = null){

        addExtraDataLambda?.let {lambda ->
            val builder = KeyValueBuilder(crashlytics)
            builder.lambda()
        }

        crashlytics.recordException(exception)
    }
}