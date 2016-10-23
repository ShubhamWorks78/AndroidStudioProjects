package com.seals.shubham.quizwithsql;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class finalQues extends AppCompatActivity {
    Button sub,exit;
    QuestionShow db = new QuestionShow(this);
    String ans,usrans;
    TextView ques;
    int quest_count,correct_count,answer,i;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_ques);
        ques = (TextView)findViewById(R.id.finShwQuest);
        rg = (RadioGroup)findViewById(R.id.finShwRadGrp);
        rb1 = (RadioButton)findViewById(R.id.finShwQuesChc1);
        rb2 = (RadioButton)findViewById(R.id.finShwQuesChk2);
        rb3 = (RadioButton)findViewById(R.id.finShwQuesChk3);
        rb4 = (RadioButton)findViewById(R.id.finShwQuesChk4);
        sub = (Button)findViewById(R.id.finBtnUsrQuesSub);
        exit = (Button)findViewById(R.id.finBtnUsrQuesQuit);
        Bundle extras = getIntent().getExtras();
        quest_count = Integer.parseInt(extras.getString("No_Quest"));
        correct_count = Integer.parseInt(extras.getString("No_Correct"));
        String ic = extras.getString("I");
        i = Integer.parseInt(ic);
        this.setQues();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(finalQues.this);
                ab.setMessage("Do you wanna end the test??...");
                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent in = new Intent(finalQues.this,UserPage.class);
                        startActivity(in);
                    }
                });
                ab.show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked())
                    usrans = rb1.getText().toString();
                else if(rb2.isChecked())
                    usrans = rb2.getText().toString();
                else if(rb3.isChecked())
                    usrans = rb3.getText().toString();
                else if(rb4.isChecked())
                    usrans = rb4.getText().toString();
                quest_count++;
                if(usrans.equals(ans))
                {
                    correct_count++;
                    Intent i = new Intent(finalQues.this,FinalResults.class);
                    i.putExtra("No_Quest",""+quest_count);
                    i.putExtra("No_Correct",""+correct_count);
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(finalQues.this,FinalResults.class);
                    i.putExtra("No_Quest",""+quest_count);
                    i.putExtra("No_Correct",""+correct_count);
                    startActivity(i);
                }
            }
        });
    }
    public void setQues()
    {
        i++;
        String str = db.find_no();
        ques.setText("Q."+i+". "+db.showData(1,str));
        rb1.setText(""+db.showData(2,str));
        rb2.setText(""+db.showData(3,str));
        rb3.setText(""+db.showData(4,str));
        rb4.setText(""+db.showData(5,str));
        ans = db.showData(6,str);
        Toast.makeText(finalQues.this,""+ans,Toast.LENGTH_LONG).show();
    }
}
