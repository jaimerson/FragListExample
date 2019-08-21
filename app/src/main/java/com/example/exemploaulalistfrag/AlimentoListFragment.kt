package com.example.exemploaulalistfrag

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import java.lang.RuntimeException

class AlimentoListFragment : ListFragment() {

    private var adapter : ArrayAdapter<Alimento>? = null
    private var listener: OnItemClickAlimento? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context !is OnItemClickAlimento){
            throw RuntimeException("Não é um alimento.")
        }

        listener = context
    }

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

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var alimento = adapter?.getItem(position)
        if(alimento != null){
            listener?.onClick(alimento)
        }
    }

    interface OnItemClickAlimento {
        fun onClick(alimento: Alimento)
    }
}