package mx.tecnm.tepic.ladm_u4_p2_canva_sensor

import android.content.Context
import android.graphics.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi


class Lienzo (p:MainActivity,a:SensorManager): View(p), SensorEventListener {

    val feliz= BitmapFactory.decodeResource(resources,R.drawable.comer)
    val enojado= BitmapFactory.decodeResource(resources,R.drawable.enojado)
    var cara = feliz
    var xsens = 0f
    var ysens = 0f
    val manager = a

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        //oyente
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)
        c.drawBitmap(cara,(xsens*150)+200f,(ysens*150)-500,p)
        invalidate()
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        return true
    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        if(Sensor.TYPE_ACCELEROMETER==event.sensor.type){
            xsens=event.values[0]
            ysens=event.values[1]
            invalidate()
        }
        if(Sensor.TYPE_PROXIMITY==event.sensor.type){
            if(event.values[0]>5)
            {
                cara = enojado
            }
            if(event.values[0]<5)
            {
                cara = feliz
            }
            invalidate()
        }
    }
}