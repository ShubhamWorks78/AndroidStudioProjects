package com.seals.shubham.contentproviderapplication;

import android.app.Instrumentation;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.imageView);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            Uri uri = data.getData();
            String myPath = getPath(uri);
            Bitmap bmp = BitmapFactory.decodeFile(myPath);
            iv.setImageBitmap(bmp);
        }
    }

    private String getPath(Uri uri) {
        String projection[] = {MediaStore.Images.Media.DATA};
        Cursor c = getContentResolver().query(uri,projection,null,null,null);
        c.moveToNext();
        int index = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        return c.getString(index);
    }
}
