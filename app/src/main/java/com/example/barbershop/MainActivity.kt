package com.example.barbershop

import android.R
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.AirplaneModeChangeReceiver
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var receiver: AirplaneModeChangeReceiver
    lateinit var notificacao: Notificacao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receiver = AirplaneModeChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                nome.isEmpty() -> {
                    mensagem(it, "Coloque seu nome!")
                }

                senha.isEmpty() -> {
                    mensagem(it, "Coloque sua senha!")
                }

                senha.length <= 5 -> {
                    mensagem(it, "Senha precisa de 6 caracteres!")
                }

                else -> {

                    if (nome.equals("Ebert") && senha.equals("123456")) {
                        navegarHome(nome)
                    } else {
                        mensagem(it, "Nome ou Senha incorretos!")

                        var titu: String = "Claudio"
                        var desc: String = "Kauã"
                        notificacao.notificacao(titu, desc);
                    }
                }
            }
        }
    }


    private fun mensagem(view: View, mensagem: String) {
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navegarHome(nome: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("nome", nome)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}



