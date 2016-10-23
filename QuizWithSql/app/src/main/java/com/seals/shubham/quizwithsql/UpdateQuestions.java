package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdateQuestions extends AppCompatActivity {
    Button sub,bck;
    String quest_no,ques,opa,opb,opc,opd,corr;
    EditText quest,opta,optb,optc,optd,correct;
    QuestionShow db = new QuestionShow(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_questions);
        quest = (EditText)findViewById(R.id.updQuesQ);
        opta = (EditText)findViewById(R.id.updQuesA);
        optb = (EditText)findViewById(R.id.updQuesB);
        optc = (EditText)findViewById(R.id.updQuesC);
        optd = (EditText)findViewById(R.id.updQuesD);
        correct = (EditText)findViewById(R.id.updCorr);
        sub = (Button)findViewById(R.id.btnUpdQuesSub);
        bck = (Button)findViewById(R.id.btnUpdQuesBack);
        Bundle extra = getIntent().getExtras();
        final String qust = extra.getString("Question");
        HashMap<String,String> data = db.getQuestion(qust);
        quest.setText(data.get("Question"));
        Toast.makeText(UpdateQuestions.this,""+data.get("Question"),Toast.LENGTH_LONG).show();
        opta.setText(data.get("OptA"));
        optb.setText(data.get("OptB"));
        optc.setText(data.get("OptC"));
        optd.setText(data.get("OptD"));
        correct.setText(data.get("Correct"));
        quest_no = data.get("Quest_No");
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateQuestions.this,ShowAllQuestion.class);
                startActivity(i);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ques = quest.getText().toString();
                opa = opta.getText().toString();
                opb = optb.getText().toString();
                opc = optc.getText().toString();
                opd = optd.getText().toString();
                corr = correct.getText().toString();
                db.updateQuestion(quest_no,ques,opa,opb,opc,opd,corr);
                Intent i = new Intent(UpdateQuestions.this,ShowAllQuestion.class);
                startActivity(i);
            }
        });
    }
}
