package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R

class MapScreen: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_map, container, false)
    }


}