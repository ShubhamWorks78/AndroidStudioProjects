package com.seals.shubham.externalmemoryapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File myFile = new File(Environment.getExternalStorageDirectory().getPath()+File.separator+"ShubhamGeeks");
        myFile.mkdir();
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"ShubhamGeeks";
                Bitmap bmp = BitmapFactory.decodeFile(path);
                iv.setImageBitmap(bmp);
            }
        });
    }
}
