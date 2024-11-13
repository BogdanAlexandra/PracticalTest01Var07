package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

open class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Logica pentru a manipula intențiile primite
        val value1 = intent?.getIntExtra("value1", -1)
        val value2 = intent?.getIntExtra("value2", -1)
        val value3 = intent?.getIntExtra("value3", -1)
        val value4 = intent?.getIntExtra("value4", -1)

    }
}
