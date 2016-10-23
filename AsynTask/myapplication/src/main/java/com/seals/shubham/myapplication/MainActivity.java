package com.seals.shubham.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextToSpeech mTextToSpeech;
    Button btn;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        ed = (EditText)findViewById(R.id.editText);
        mTextToSpeech = new TextToSpeech(this,this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ed.getText().toString();
                mTextToSpeech.speak(str,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
    @Override
    public void onInit(int status) {
        
    }
}
