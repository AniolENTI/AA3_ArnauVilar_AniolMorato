package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppTopBar: Fragment() {

    companion object {
        private lateinit var Instance: AppTopBar

        fun get() = Instance
    }

    lateinit var topBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_topbar, container, false)
        topBar = view.findViewById(R.id.AppNavigationTopBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topBar.setOnItemSelectedListener { menuItem ->

            AppToolbar.get().toolbar.title = menuItem.title

            if(menuItem.itemId != topBar.selectedItemId) {
                when (menuItem.itemId) {
                    R.id.equipment_top_bar_button -> {

                    }

                    R.id.consumables_top_bar_button -> {

                    }

                    R.id.key_items_top_bar_button -> {

                    }
                }
            }
            true
        }
        topBar.selectedItemId = topBar.menu.getItem(0).itemId
    }

}