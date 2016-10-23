package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPage extends AppCompatActivity {
    Button add,upd,del,shw,log;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        add = (Button)findViewById(R.id.btnAdmAdd);
        upd = (Button)findViewById(R.id.btnAdmUpd);
        del = (Button)findViewById(R.id.btnAdmDel);
        shw = (Button)findViewById(R.id.btnAdmShow);
        log = (Button)findViewById(R.id.btnAdmLogO);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPage.this,AddQuestions.class);
                startActivity(i);
            }
        });
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        shw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPage.this,ShowAllQuestion.class);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminPage.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
