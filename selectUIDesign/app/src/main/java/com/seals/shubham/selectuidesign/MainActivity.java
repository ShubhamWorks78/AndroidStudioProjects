package com.seals.shubham.selectuidesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
        lis.set
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.and){
            Toast.makeText(this,"Hiii Android",Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.Sym){
            Toast.makeText(this,"Hii Symbian!!!You are too Old",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
