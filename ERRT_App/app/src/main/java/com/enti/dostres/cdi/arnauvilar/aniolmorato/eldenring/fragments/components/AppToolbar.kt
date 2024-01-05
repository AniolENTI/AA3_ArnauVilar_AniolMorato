package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.clases.firebase.FB
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.Firebase
import com.google.firebase.crashlytics.crashlytics
import com.google.firebase.crashlytics.setCustomKeys

class AppToolbar: Fragment() {

    companion object {
        private lateinit var Instance: AppToolbar
        fun get() = Instance
    }

    lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_toolbar, container, false)
        toolbar = view.findViewById(R.id.AppToolbar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            AppDrawer.get().openDrawer()
        }

        toolbar.setOnMenuItemClickListener { menuItem ->

            when(menuItem.itemId) {
                R.id.toolbar_button_test -> {
                    //throw RuntimeException("Test Crash") // Force a crash
                    FB.crashlytics.logSimpleError("Subnormal Error") {
                        key("Subnormal Name", "Abraham")
                        key("IsSubnormal", true)
                        key("Level of Subnormality", 9001)
                    }
                }
            }
            true
        }
    }
}