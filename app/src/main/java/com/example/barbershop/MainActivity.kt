package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import android.hardware.biometrics.BiometricManager
import android.hardware.biometrics.BiometricPrompt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.core.content.ContextCompat
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener{
            val nome = binding.editNome.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                nome.isEmpty() -> {
                    mensagem(it, "Coloque seu nome!")
                }senha.isEmpty() ->{
                    mensagem(it, "Coloque sua senha!")
                }senha.length <= 5 ->{
                    mensagem(it, "Senha precisa de 6 caracteres!")
                }else -> {
                    navegarHome(nome)
                }
            }
        }
    }


    private fun mensagem(view: View, mensagem: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
    private fun navegarHome(nome: String){
        val intent = Intent(this,Home::class.java)
        intent.putExtra("nome", nome)
        startActivity(intent)
    }
}