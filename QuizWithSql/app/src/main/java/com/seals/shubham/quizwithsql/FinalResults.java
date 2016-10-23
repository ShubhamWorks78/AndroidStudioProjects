package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalResults extends AppCompatActivity {
    QuestionShow db = new QuestionShow(this);
    String no_quest,no_correct;
    TextView quest,correct,perf;
    Button hme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_results);
        db.empty();
        Show_Questions sc = new Show_Questions();
        sc.empty();
        Bundle extras = getIntent().getExtras();
        no_correct = extras.getString("No_Correct");
        no_quest = extras.getString("No_Quest");
        quest = (TextView)findViewById(R.id.finResQuest);
        correct = (TextView)findViewById(R.id.finResCorr);
        perf = (TextView)findViewById(R.id.finResPerf);
        hme = (Button)findViewById(R.id.finBtnHome);
        hme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FinalResults.this,UserPage.class);
                startActivity(i);
            }
        });
        quest.setText("Total Questions:- "+no_quest);
        correct.setText("Correct:- "+no_correct);
        perf.setText(""+this.per(no_quest,no_correct));
    }

    private String per(String no_quest, String no_correct) {
        int ques = Integer.parseInt(no_quest);
        int corr = Integer.parseInt(no_correct);
        double res = (double)(corr/ques);
        if(res>=0.9)
            return "Excellent";
        else if(res<0.9 && res>=0.8)
            return "Nice";
        else if(res<0.8 && res>=0.65)
            return "Good";
        else
            return "Improvement Required";
    }
}
