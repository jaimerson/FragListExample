package com.example.exemploaulalistfrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exemploaulalistfrag.AlimentoListFragment.OnItemClickAlimento

class MainActivity : AppCompatActivity(), OnItemClickAlimento {

    private var textFragment: TextFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFragment = supportFragmentManager
            .findFragmentById(R.id.frag_text) as TextFragment
    }

    override fun onClick(alimento: Alimento) {
        textFragment?.setMsgText(
            "O preço de ${alimento} é ${alimento.preco}"
        )
    }
}
