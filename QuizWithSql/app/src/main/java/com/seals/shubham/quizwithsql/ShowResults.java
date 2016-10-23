package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.Toast;

public class ShowResults extends AppCompatActivity {
    Handler hnd;
    QuestionShow db = new QuestionShow(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        hnd = new Handler();
        String ans = getIntent().getExtras().getString("Value").toString();
        Toast.makeText(ShowResults.this,""+ans,Toast.LENGTH_LONG).show();
        String val = null;
        Bundle extras = getIntent().getExtras();
        String quest_no = extras.getString("No_Quest");
        String correct_no = extras.getString("No_Correct");
        String ic = extras.getString("I");
        if(ans.equals("1"))
            val = "Correct Answer";
        else if(ans.equals("0"))
            val = "Wrong Answer";
        final String str = val;
        hnd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ShowResults.this,""+str,Toast.LENGTH_LONG).show();
            }
        },15000);
        int no = db.findNo();
        int co = db.length();
        Log.w("No",""+no);
        Log.w("Co",""+co);
        if((no-co)==1)
        {
            db.print();
            Intent i = new Intent(ShowResults.this,finalQues.class);
            i.putExtra("No_Quest",quest_no);
            i.putExtra("No_Correct",correct_no);
            i.putExtra("I",ic);
            startActivity(i);
        }
        else {
            db.print();
            Intent i = new Intent(ShowResults.this, Show_Questions.class);
            startActivity(i);
        }
    }
}
