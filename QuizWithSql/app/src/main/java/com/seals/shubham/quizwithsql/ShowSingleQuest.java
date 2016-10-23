package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class ShowSingleQuest extends AppCompatActivity {
    QuestionShow db = new QuestionShow(this);
    TextView quest,opta,optb,optc,optd,correct;
    Button bck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_single_quest);
        quest = (TextView)findViewById(R.id.shwQuesQ);
        opta = (TextView)findViewById(R.id.shwQuesA);
        optb = (TextView)findViewById(R.id.shwQuesB);
        optc = (TextView)findViewById(R.id.shwQuesC);
        optd = (TextView)findViewById(R.id.shwQuesD);
        correct = (TextView)findViewById(R.id.shwCorr);
        bck = (Button)findViewById(R.id.btnShwQuesBck);
        Bundle extras = getIntent().getExtras();
        String question = extras.getString("Question").toString();
        HashMap<String,String> data = db.getQuestion(question);
        quest.setText("Q. "+data.get("Question"));
        opta.setText("A. "+data.get("OptA"));
        optb.setText("B. "+data.get("OptB"));
        optc.setText("C. "+data.get("OptC"));
        optd.setText("D. "+data.get("OptD"));
        correct.setText("Ans. "+data.get("Correct"));
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowSingleQuest.this,ShowAllQuestion.class);
                startActivity(i);
            }
        });
    }
}
