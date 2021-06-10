package mx.tecnm.tepic.ladm_u4_p2_canva_sensor

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //solicitar servicio de sensor
        sensorManager=getSystemService(Context.SENSOR_SERVICE)as SensorManager
        setContentView(Lienzo(this,sensorManager))
    }

    override fun onSensorChanged(event: SensorEvent?) {


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}