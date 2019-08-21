package com.example.exemploaulalistfrag

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment

class AlimentoListFragment : ListFragment() {

    private var adapter : ArrayAdapter<Alimento>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1)

        var nomes = requireActivity()
            .resources
            .getStringArray(R.array.alimentos_nomes)
        var precos = requireActivity()
            .resources
            .getStringArray(R.array.alimentos_precos)

        for(i in nomes.indices){
            var alimento = Alimento(nomes[i], precos[i].toDouble())
            adapter?.add(alimento)
        }

        listAdapter = adapter
    }
}