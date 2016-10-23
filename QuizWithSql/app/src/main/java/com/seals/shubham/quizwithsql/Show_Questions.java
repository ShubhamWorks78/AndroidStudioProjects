package com.seals.shubham.quizwithsql;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Show_Questions extends AppCompatActivity {
    static int k = 0;
    static int ques_Count = 0;
    static int correct_Count = 0;
    Button nxt,exit;
    QuestionShow db = new QuestionShow(this);
    String ans,usrans;
    TextView ques;
    int answer;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    final String stre = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__questions);
        ques = (TextView)findViewById(R.id.shwQuest);
        rg = (RadioGroup)findViewById(R.id.shwRadGrp);
        rb1 = (RadioButton)findViewById(R.id.shwQuesChc1);
        rb2 = (RadioButton)findViewById(R.id.shwQuesChk2);
        rb3 = (RadioButton)findViewById(R.id.shwQuesChk3);
        rb4 = (RadioButton)findViewById(R.id.shwQuesChk4);
        nxt = (Button)findViewById(R.id.btnUsrQuesSub);
        exit = (Button)findViewById(R.id.btnUsrQuesQuit);
        final int m,n;
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
               answer = i;
            }
        });
        //int str = db.findNo();
        //String st = db.find_no();
        //ques.setText(""+str);
        //rb1.setText(""+st);
        /*if(db.chckNo()==0)
            this.setQues();
        else if(db.chckNo()==1)
        {
            Intent i = new Intent(Show_Questions.this,finalQues.class);
            startActivity(i);
        }*/
        this.setQues();
        nxt.setOnClickListener(new View.OnClickListener() {
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
                //Log.d("Val",usrans);
                ques_Count++;
                Toast.makeText(Show_Questions.this,""+usrans,Toast.LENGTH_LONG).show();
                if(usrans.equals(ans)) {
                    Intent i = new Intent(Show_Questions.this,ShowResults.class);
                    correct_Count++;
                    i.putExtra("Value","1");
                    i.putExtra("No_Quest",""+ques_Count);
                    i.putExtra("No_Correct",""+correct_Count);
                    i.putExtra("I",""+k);
                    Toast.makeText(Show_Questions.this,"Correct Answer",Toast.LENGTH_LONG).show();
                    startActivity(i);
                }else {
                    Intent i = new Intent(Show_Questions.this,ShowResults.class);
                    i.putExtra("Value","0");
                    i.putExtra("No_Quest",""+ques_Count);
                    i.putExtra("No_Correct",""+correct_Count);
                    i.putExtra("I",""+k);
                    Toast.makeText(Show_Questions.this,"Wrong Answer",Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(Show_Questions.this);
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
                        Intent in = new Intent(Show_Questions.this,UserPage.class);
                        startActivity(in);
                    }
                });
                ab.show();
            }
        });
    }
    public void setQues()
    {
        k++;
        String str = db.find_no();
        ques.setText("Q."+k+". "+db.showData(1,str));
        rb1.setText(""+db.showData(2,str));
        rb2.setText(""+db.showData(3,str));
        rb3.setText(""+db.showData(4,str));
        rb4.setText(""+db.showData(5,str));

        ans = db.showData(6,str);
        Toast.makeText(Show_Questions.this,""+ans,Toast.LENGTH_LONG).show();
    }
    public void empty()
    {
        ques_Count = 0;
        correct_Count = 0;
        k = 0;
    }
}
