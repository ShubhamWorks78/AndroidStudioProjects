package com.seals.shubham.quizprojectwithserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Registration extends AppCompatActivity {
    static ArrayList<String> arr = new ArrayList<String>();
    EditText nam,usr,pass,mob,gen;
    Random rand = new Random();
    StringRequest stringRequest;
    String url = "http://shubhamshanky.coolpage.biz/RegistrationDb.php";
    RequestQueue mRequestQueue;
    RadioGroup rg;
    AutoCompleteTextView type;
    final String data[] = {"User","Admin"};
    String name,user,passW,mobi,typeU,val,gend;
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        nam = (EditText)findViewById(R.id.editName);
        usr = (EditText)findViewById(R.id.editUser);
        pass = (EditText)findViewById(R.id.editPass);
        mob = (EditText)findViewById(R.id.editPhone);
        type = (AutoCompleteTextView)findViewById(R.id.editType);
        rg = (RadioGroup) findViewById(R.id.radGrp);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(Registration.this,android.R.layout.simple_list_item_1,data);
        type.setThreshold(2);
        type.setAdapter(ad);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radM)
                    gend = "Male";
                else if(i==R.id.radF)
                    gend = "Female";
            }
        });
        sub = (Button)findViewById(R.id.btnSign);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nam.getText().toString();
                user = usr.getText().toString();
                passW = pass.getText().toString();
                mobi = mob.getText().toString();
                typeU = type.getText().toString();
                val = ""+findRand();
                if(val!=null && name!=null && user!=null && pass!=null && gend!=null && typeU!=null && mobi!=null) {
                    mRequestQueue = Volley.newRequestQueue(Registration.this);
                    stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<String, String>();
                            param.put("UserId", val);
                            param.put("Name", name);
                            param.put("Username", user);
                            param.put("Password", passW);
                            param.put("Gender", gend);
                            param.put("UserType", typeU);
                            param.put("Mobile", mobi);
                            return param;
                        }
                    };
                }
                };
            }
        );
        mRequestQueue.add(stringRequest);
    }
    public int findRand()
    {
        int val = rand.nextInt();
        String str = ""+val;
        while(arr.contains(str))
        {
            val = rand.nextInt();
            str = ""+val;
        }
        arr.add(str);
        return val;
    }
}
