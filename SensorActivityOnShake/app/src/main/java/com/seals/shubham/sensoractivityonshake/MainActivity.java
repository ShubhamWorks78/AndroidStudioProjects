package com.seals.shubham.sensoractivityonshake;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor sense;
    Button btn;
    TextView tv1,tv2,tv3,tv4;
    float[] myValues;
    float x,y,z,threshold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv4 = (TextView)findViewById(R.id.textView4);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        btn = (Button)findViewById(R.id.button);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            myValues = sensorEvent.values;
            x = myValues[0];
            y = myValues[1];
            z = myValues[2];
            tv1.setText(""+x);
            tv2.setText(""+y);
            tv3.setText(""+z);
            threshold = ((x*y+y*z+z*x)/sm.GRAVITY_EARTH);
            tv4.setText(""+threshold);
            if(threshold>=4 && threshold<4.5)
            {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("7250752237",null,"Hey Sms Received",null,null);
            }
            else if(threshold>=4.5 && threshold<5)
            {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);
            }
            else {
                Intent i = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                startActivity(i);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
