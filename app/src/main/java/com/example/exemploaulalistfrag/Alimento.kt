package com.example.exemploaulalistfrag

data class Alimento(var nome: String, var preco: Double) {
    override fun toString(): String {
        return this.nome
    }
}