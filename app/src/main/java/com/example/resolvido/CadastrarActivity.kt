package com.example.resolvido

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Context


class CadastrarActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1 // Uma constante para o código de solicitação da imagem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val editTextNF = findViewById<EditText>(R.id.editTextNF)
        val editTextCodigoProduto = findViewById<EditText>(R.id.editTextCodigoProduto)
        val buttonAnexarFoto = findViewById<Button>(R.id.buttonAnexarFoto)
        val buttonEnviarPedido = findViewById<Button>(R.id.buttonEnviarPedido)
        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)

        buttonVoltar.setOnClickListener {
            finish() // Fecha a atividade atual e retorna à atividade anterior
        }


        buttonAnexarFoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        buttonEnviarPedido.setOnClickListener {
            val nf = editTextNF.text.toString()
            val codigoProduto = editTextCodigoProduto.text.toString()
            val statusPedido = "Aguardando" // Defina o status do pedido como "Aguardando"

            // Envie os dados para o servidor ou armazene localmente, conforme necessário
            val sharedPreferences = getSharedPreferences("pedidos", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("nf", nf)
            editor.putString("codigoProduto", codigoProduto)
            editor.putString("statusPedido", statusPedido)
            editor.apply()

            // Exemplo de exibição de uma mensagem de sucesso
            Toast.makeText(this@CadastrarActivity, "Pedido enviado com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Manipule a imagem selecionada aqui
            val selectedImageUri = data.data
            // Faça o que você precisa com a imagem
        }
    }
}
