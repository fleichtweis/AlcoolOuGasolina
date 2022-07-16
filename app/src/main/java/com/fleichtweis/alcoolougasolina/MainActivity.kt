package com.fleichtweis.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editPrecoAlcool: EditText
    private lateinit var editPrecoGasolina: EditText
    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPrecoAlcool = findViewById(R.id.edit_preco_alcool)
        editPrecoGasolina = findViewById(R.id.edit_preco_gasolina)
        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)

        btnCalcular.setOnClickListener {
            if (validarCampos()){
                calcular()
            }
        }
    }

    private fun calcular(){
        val precoAlcool = editPrecoAlcool.text.toString().toDouble()
        val precoGasolina = editPrecoGasolina.text.toString().toDouble()

        //Se (precoAlcool / precoGasolina) > 0.7 é melhor usar gasolina.
        val resultado = precoAlcool / precoGasolina
        if (resultado > 0.7){
            textResultado.text = "Melhor utilizar Gasolina"
        } else{
            textResultado.text = "Melhor utilizar Álcool"
        }

    }

    private fun validarCampos(): Boolean{
        if (editPrecoAlcool.text.isEmpty()){
            Toast.makeText(this, "Preencha o preço do álcool", Toast.LENGTH_LONG).show()
            return false
        }
        if (editPrecoGasolina.text.isEmpty()){
            Toast.makeText(this, "Preencha o preço da gasolina", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}