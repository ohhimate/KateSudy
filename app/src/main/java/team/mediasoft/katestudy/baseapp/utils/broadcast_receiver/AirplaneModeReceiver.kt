package team.mediasoft.katestudy.baseapp.utils.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import javax.inject.Inject

class AirplaneModeReceiver @Inject constructor() : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isAirplaneModeOn = intent.getBooleanExtra("state", false)
        if (isAirplaneModeOn) Toast.makeText(context, "Включен авиарежим", Toast.LENGTH_SHORT).show()
        else Toast.makeText(context, "Отключен авиарежим", Toast.LENGTH_SHORT).show()
    }
}