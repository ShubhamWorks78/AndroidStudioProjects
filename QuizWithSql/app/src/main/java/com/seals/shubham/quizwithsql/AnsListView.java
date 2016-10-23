package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AnsListView extends AppCompatActivity {
    ListView lv;
    TextView tv,tv1;
    List<String> arr;
    AnswerDb db = new AnswerDb(this);
    String[] arrayOfString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = (TextView)findViewById(R.id.textView);
        tv1 = (TextView)findViewById(R.id.textView3);
        setContentView(R.layout.activity_ans_list_view);
        lv = (ListView)findViewById(R.id.listViewShwAns);
        arr = db.getAll();
        arrayOfString = arr.toArray(new String[arr.size()]);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(AnsListView.this,android.R.layout.simple_list_item_1,arrayOfString);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String quest = ""+(i+1);
                String orig = db.getQuestionNo(quest);
                String usrAns = db.getUsrAns(quest);
                Intent j = new Intent(AnsListView.this,EditAns.class);
                j.putExtra("Original",orig);
                j.putExtra("Question",quest);
                j.putExtra("UsrAns",usrAns);
                startActivity(j);
            }
        });
    }
}
