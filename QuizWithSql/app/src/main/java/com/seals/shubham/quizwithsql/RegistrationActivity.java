package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity{
    dbController db = new dbController(this);
    RadioGroup rg;
    Button btn;
    String gender;
    EditText ed1,ed2,ed3;
    AutoCompleteTextView autoText;
    final String[] data = {"User","Admin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ed1 = (EditText) findViewById(R.id.editUser);
        ed2 = (EditText) findViewById(R.id.editPass);
        ed3 = (EditText) findViewById(R.id.editPhone);
        btn = (Button) findViewById(R.id.btnSign);
        autoText = (AutoCompleteTextView) findViewById(R.id.editType);
        rg = (RadioGroup) findViewById(R.id.radGrp);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        autoText.setThreshold(2);
        autoText.setAdapter(ad);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radM)
                    gender = "Male";
                else if (i == R.id.radF)
                    gender = "Female";
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ed1.getText().toString();
                String pass = ed2.getText().toString();
                String mob = ed3.getText().toString();
                String type = autoText.getText().toString();
                if (user != null && pass != null && mob != null && type != null && gender != null) {
                    db.insertData(user, pass, mob, gender, type);
                    Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                    startActivity(i);
                }
                 else {
                    Toast.makeText(RegistrationActivity.this, "One or more Fields not Filled", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}