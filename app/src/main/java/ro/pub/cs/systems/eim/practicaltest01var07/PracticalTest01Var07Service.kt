package ro.pub.cs.systems.eim.practicaltest01var07

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.util.*

class PracticalTest01Var07Service : Service() {

    private val handler = Handler()
    private val random = Random()

    private val runnable = object : Runnable {
        override fun run() {
            // Generează 4 valori aleatorii
            val value1 = random.nextInt(100)
            val value2 = random.nextInt(100)
            val value3 = random.nextInt(100)
            val value4 = random.nextInt(100)

            // Creează un intent cu valorile
            val intent = Intent("ro.pub.cs.systems.eim.practicaltest01var07.ACTION_SEND_VALUES")
            intent.putExtra("value1", value1)
            intent.putExtra("value2", value2)
            intent.putExtra("value3", value3)
            intent.putExtra("value4", value4)
            sendBroadcast(intent)

            // Repornește runnable la fiecare 10 secunde
            handler.postDelayed(this, 10000)
        }
    }

    override fun onCreate() {
        super.onCreate()
        // Începe să trimită mesaje la fiecare 10 secunde
        handler.post(runnable)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        // Oprește runnable când serviciul este distrus
        handler.removeCallbacks(runnable)
    }
}
