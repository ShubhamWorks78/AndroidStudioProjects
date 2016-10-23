package com.seals.shubham.mygpsproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements LocationListener {
    LocationManager mLocationManager;
    int inter = 35000;
    Button btn, btn2;
    TextView tv1, tv2, tv3;
    String late, lnge;
    StringBuilder sb;
    double lat, lng;
    Timer myTimer = new Timer();
    Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbFinal db = new dbFinal(MainActivity.this);
                db.delete();
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "Permission not fullfilled", Toast.LENGTH_LONG).show();
            return;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,35000,0,this);
        Toast.makeText(getBaseContext(), "In onCreate method after giving permissions", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Onn", Toast.LENGTH_LONG).show();
        mHandler = new Handler();
        mHandler.postDelayed(runLocation,10000);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, showData.class);
                startActivity(i);
            }
        });
    }
    public Runnable runLocation = new Runnable() {
        @Override
        public void run() {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(cal.getTime());
            dbFinal db = new dbFinal(MainActivity.this);
            if (sb != null)
                db.insertData(time, late, lnge, sb.toString());
            MainActivity.this.mHandler.postDelayed(runLocation,600000);
        }
    };


    @Override
    public void onLocationChanged(Location location) {

        Toast.makeText(this, "Reached Location Changed", Toast.LENGTH_LONG).show();
        lat = location.getLatitude();
        lng = location.getLongitude();
        late = "" + lat;
        lnge = "" + lng;
        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.ENGLISH);

        tv1.setText(late);
        tv2.setText(lnge);
        try {
            List<Address> myList = geocoder.getFromLocation(lat, lng, 1);
            sb = new StringBuilder();
            if (myList.size() > 0) {
                Address myAddress = myList.get(0);
                for (int i = 0; i < myAddress.getMaxAddressLineIndex(); i++) {
                    sb.append(myAddress.getAddressLine(i));

                }
                tv3.setText("" + sb.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(this, "Onn", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(this, "Off", Toast.LENGTH_LONG).show();
    }
}