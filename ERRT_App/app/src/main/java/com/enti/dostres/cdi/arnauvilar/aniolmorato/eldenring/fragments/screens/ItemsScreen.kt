package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.R
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemAdapter
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemProvider
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories.ItemApiService
import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.fragments.components.AppTopBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsScreen : Fragment() {

    private lateinit var table: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.componentToolbarContainer, AppTopBar())
            .commit()

        table = view.findViewById(R.id.my_items_table)
        table.layoutManager = LinearLayoutManager(requireContext())

        val repository = ItemApiService()
        val provider = ItemProvider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val items = provider.GetAllItems()

            CoroutineScope(Dispatchers.Main).launch {

                table.adapter = ItemAdapter(items)
            }
        }
    }
}

    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_items, container, false)
    }*/