package com.seals.shubham.wallpaperchanger;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Integer img[] = {R.raw.redfort,R.raw.redfortfi,R.raw.redforto,R.raw.redfortt,R.raw.redfortth,R.raw.selectcitywalk};
    Button btn;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setResource(img[i]);
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
