package com.seals.shubham.progressbarproject;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int myProgress;
    long fileSize;
    Handler hnd = new Handler();
    ProgressDialog pd;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn)
        {
            pd = new ProgressDialog(this);
            pd.setMessage("Wait...");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
            pd.incrementProgressBy(10);
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while(myProgress<=100)
                    {
                        myProgress = TODOSOMETASK();
                        try{
                            Thread.sleep(1000);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                        hnd.post(new Runnable() {
                            @Override
                            public void run() {
                                pd.setProgress(myProgress);
                            }
                        });
                    }
                }


                private int TODOSOMETASK() {
                    while(fileSize<100000)
                    {
                        fileSize++;
                        if(fileSize%10000==0)
                        {
                            return (int)fileSize/10000*10;
                        }
                    }
                    return 100;
                }
            }).start();

        }
    }
}
