package com.anderson.dev.app.gastoviajem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.anderson.dev.app.gastoviajem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )

        supportActionBar?.hide()

        binding.buttonCalcular.setOnClickListener( this )
    }
    override fun onClick(view: View) {
        if ( view.id == R.id.button_calcular){
            calcular()


        }

    }

    private fun validacao(): Boolean{
        return (binding.editDistancia.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomia.text.toString() != ""
                && binding.editAutonomia.text.toString().toFloat() != 0f)
    }
    private fun calcular(){
        if ( validacao() ){

       val distancia = binding.editDistancia.text.toString().toFloat()
        val preco = binding.editPreco.text.toString().toFloat()
        val autonomia = binding.editAutonomia.text.toString().toFloat()

        val totalResultado = ( distancia * preco) / autonomia

        binding.textTotal.text = "R$ ${"%.2f".format( totalResultado )}"

         }else{

            Toast.makeText( this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
         }





    }


}