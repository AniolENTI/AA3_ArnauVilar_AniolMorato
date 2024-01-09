package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase.FB
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private val requestNotificationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        onNotificationPermissionResponse(isGranted)
    }

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.main_activity_screen)

        setTheme(FB.remoteConfig.getTheme().themeId)

    }

    fun onNotificationPermissionResponse(isGranted: Boolean)
    {
        if(isGranted)
        {
            FirebaseMessaging.getInstance().token
                .addOnSuccessListener { token ->
                    println("Token::> " + token)
                }
                .addOnFailureListener {
                    //ERROR
                }
        }
        else
        {
            //ERROR
        }
    }

    fun askNotificationPermission() {

        val permission = Manifest.permission.POST_NOTIFICATIONS

        if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED){
            FirebaseMessaging.getInstance().token
                .addOnSuccessListener { token ->
                    println("Token::> " + token)
                }
                .addOnFailureListener {
                    //ERROR
                }
        }
        else if(shouldShowRequestPermissionRationale(permission)){

        }
        else{
            requestNotificationPermissionLauncher.launch(permission)
        }
    }

}