package com.seals.shubham.proximitysensor;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    Sensor sense;
    SensorManager sm;
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sense = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sense==null)
        {
            tv1.setText("NO Proximity Sensor!");
        }
        else
        {
            tv1.setText(sense.getName());
            tv2.setText("Maximum range is "+sense.getMaximumRange());
            sm.registerListener(this,sense,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,sm.getDefaultSensor(SensorManager.SENSOR_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_PROXIMITY)
        {
            float dist = sensorEvent.values[0];
            Toast.makeText(this,"Value is "+dist,Toast.LENGTH_LONG).show();
            tv3.setText("Dist is "+dist);
            if(dist==0)
            {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
