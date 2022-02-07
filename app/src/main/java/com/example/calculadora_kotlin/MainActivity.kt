package com.example.calculadora_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

//val operatorList = arrayOf("Soma","Multiplicacao","Divisao","Resto","Exponencial","Fatorial")
//var a:Float = 0.00F; val b:Float = 0.00F
//var cont = true

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        soma.setOnClickListener() {
            val a = (n1.text.toString()).toFloat()
            val b = (n2.text.toString()).toFloat()
            with(result) {
                result.setTextColor(Color.RED)
                result.setText((a + b).toString())
            }
        }

        mult.setOnClickListener() {
            val a = (n1.text.toString()).toFloat()
            val b = (n2.text.toString()).toFloat()
            result.setTextColor(Color.RED)
            result.setText((a * b).toString())
        }

        div.setOnClickListener() {
            val a = (n1.text.toString()).toFloat()
            val b = (n2.text.toString()).toFloat()
            result.setTextColor(Color.RED)
            result.setText((a / b).toString())
        }

        resto.setOnClickListener(){
            val a = (n1.text.toString()).toFloat()
            val b = (n2.text.toString()).toFloat()
            result.setTextColor(Color.RED)
            result.setText((a % b).toString())
        }

        power.setOnClickListener(){
            val a = (n1.text.toString()).toFloat()
            val b = (n2.text.toString()).toFloat()
            result.setTextColor(Color.RED)
            result.setText((a.pow(b)).toString())
        }

    }


}