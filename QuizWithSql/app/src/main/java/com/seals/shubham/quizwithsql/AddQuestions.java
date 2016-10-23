package com.seals.shubham.quizwithsql;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestions extends AppCompatActivity {
    QuestionShow db = new QuestionShow(this);
    EditText ques,optA,optB,optC,optD,Corr;
    Button sub,bck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);
        ques = (EditText)findViewById(R.id.addQuesQ);
        optA = (EditText)findViewById(R.id.addQuesA);
        optB = (EditText)findViewById(R.id.addQuesB);
        optC = (EditText)findViewById(R.id.addQuesC);
        optD = (EditText)findViewById(R.id.addQuesD);
        Corr = (EditText)findViewById(R.id.addCorr);
        sub = (Button) findViewById(R.id.btnQuesSub);
        bck = (Button)findViewById(R.id.btnQuesBack);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String que = ques.getText().toString();
                String opA = optA.getText().toString();
                String opB = optB.getText().toString();
                String opC = optC.getText().toString();
                String opD = optD.getText().toString();
                String Cor = Corr.getText().toString();
                if(que!=null && opA!=null && opB!=null && opC!=null && opD!=null && Cor!=null) {
                    db.insertData(que, opA, opB, opC, opD,Cor);
                    Toast.makeText(AddQuestions.this,"Question has been added Successfully",Toast.LENGTH_LONG).show();
                    ques.setText("");
                    optA.setText("");
                    optB.setText("");
                    optC.setText("");
                    optD.setText("");
                    Corr.setText("");
                }
                else
                    Toast.makeText(AddQuestions.this,"Insert data in all the values then try it",Toast.LENGTH_LONG).show();
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddQuestions.this,AdminPage.class);
                startActivity(i);
            }
        });
    }
}
