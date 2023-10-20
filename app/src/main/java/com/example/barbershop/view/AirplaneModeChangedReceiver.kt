package com.example.barbershop.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver {

    override fun onReceive(context: Context?, intent: Intent?){
        val isAirplaneModeChangedReceiver = intent?.getBooleanExtra("state", false)?: return
        if (isAirplaneModeChangedReceiver){
            Toast.makeText(context, "Airplane mode is enabled", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(context, "Airplane mode is disabled", Toast.LENGTH_LONG).show()
        }
    }
}