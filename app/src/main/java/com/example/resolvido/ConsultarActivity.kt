package com.example.resolvido

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConsultarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        // Recupere os detalhes do pedido armazenados em SharedPreferences
        val sharedPreferences = getSharedPreferences("pedidos", Context.MODE_PRIVATE)
        val nf = sharedPreferences.getString("nf", "")
        val codigoProduto = sharedPreferences.getString("codigoProduto", "")
        val statusPedido = sharedPreferences.getString("statusPedido", "")

// Agora você pode exibir esses detalhes na tela de consulta conforme necessário

    }
}