package com.example.barbershop.view

import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbershop.R
import com.example.barbershop.adapter.ServicoAdapter
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.model.Servicos
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicoAdapter: ServicoAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtNomeUser.text = "Bem-vindo, $nome"
        val recyclerViewServicos = binding.recyclerView
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicoAdapter = ServicoAdapter(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicoAdapter
        getServico()

        binding.btAgenda.setOnClickListener {
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
        binding.iconMenu.setOnClickListener {
            val intent2 = Intent(this, Menu::class.java)
            startActivity(intent2)
        }

    }

    private fun getServico(){

        val servico1 = Servicos(R.drawable.img1, "Corte de cabelo")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.img2, "Corte de barba")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.img3, "Lavagem de cabelo")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.img4, "Tratamento de cabelo")
        listaServicos.add(servico4)
    }


}