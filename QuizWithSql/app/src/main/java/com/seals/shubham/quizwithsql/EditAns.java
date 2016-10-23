package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EditAns extends AppCompatActivity {
    RadioGroup rg;
    Button sub;
    QuestionShow db = new QuestionShow(this);
    TextView ques;
    AnswerDb ansdb = new AnswerDb(this);
    RadioButton rb1,rb2,rb3,rb4;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ans);
        sub = (Button)findViewById(R.id.btnUsrQuesSub);
        rg = (RadioGroup)findViewById(R.id.shwRadGrp);
        rb1 = (RadioButton)findViewById(R.id.shwQuesChc1);
        rb2 = (RadioButton)findViewById(R.id.shwQuesChk2);
        rb3 = (RadioButton)findViewById(R.id.shwQuesChk3);
        rb4 = (RadioButton)findViewById(R.id.shwQuesChk4);
        ques = (TextView)findViewById(R.id.shwQuest);
        Bundle extras = getIntent().getExtras();
        final String ques_No = extras.getString("Question");
        String orig = extras.getString("Original");
        String usrans = extras.getString("UsrAns");
        this.setQues(ques_No,usrans,orig);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans="";
                if(rb1.isChecked())
                    ans = rb1.getText().toString();
                else if(rb2.isChecked())
                    ans = rb2.getText().toString();
                else if(rb3.isChecked())
                    ans = rb3.getText().toString();
                else if(rb4.isChecked())
                    ans = rb4.getText().toString();
                int rep = ansdb.updateAns(ques_No,ans);
                if(rep==1)
                    Toast.makeText(EditAns.this,"Successfully Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(EditAns.this,"Updation Failed",Toast.LENGTH_LONG).show();
                Intent i = new Intent(EditAns.this,AnsListView.class);
                startActivity(i);
            }
        });
    }

    public void setQues(String quest_No,String usrans,String orig)
    {
        ques.setText("Q."+quest_No+". "+db.showData(1,orig));
        rb1.setText(db.showData(2,orig));
        rb2.setText(db.showData(3,orig));
        rb3.setText(db.showData(4,orig));
        rb4.setText(db.showData(5,orig));
        if(usrans==db.showData(2,orig))
            rb1.isChecked();
        else if(usrans==db.showData(3,orig))
            rb2.isChecked();
        else if(usrans==db.showData(4,orig))
            rb3.isChecked();
        else if(usrans==db.showData(5,orig))
            rb4.isChecked();
    }
}
