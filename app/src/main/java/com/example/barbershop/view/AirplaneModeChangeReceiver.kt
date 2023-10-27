package com.example.barbershop.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false)?: return

        if(isAirplaneModeEnabled) {
            Toast.makeText(
                context,
                "Modo avião Ativado", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Modo avião desativado", Toast.LENGTH_LONG).show()
        }
    }
}