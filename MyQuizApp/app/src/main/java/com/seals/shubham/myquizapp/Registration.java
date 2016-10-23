package com.seals.shubham.myquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    final String data[] = {"User","Admin"};
    EditText nam,ema,pas,usr;
    RequestQueue rq;
    String url = "";
    AutoCompleteTextView usrt;
    String name,user,email,pass,usert;
    Button reg,log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        nam = (EditText)findViewById(R.id.EditName);
        usr = (EditText)findViewById(R.id.EditUser);
        usrt = (AutoCompleteTextView)findViewById(R.id.EditType);
        ema = (EditText)findViewById(R.id.EditEmail);
        pas = (EditText)findViewById(R.id.EditPass);
        reg = (Button)findViewById(R.id.BtnRegister);
        log = (Button)findViewById(R.id.LoginPage);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(Registration.this,android.R.layout.simple_list_item_1,data);
        usrt.setThreshold(2);
        usrt.setAdapter(ad);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nam.getText().toString();
                user = usr.getText().toString();
                usert = usrt.getText().toString();
                pass = pas.getText().toString();
                email = ema.getText().toString();
                if(name!=null && user!=null && usert!=null && pass!=null && email!=null)
                {
                    rq = Volley.newRequestQueue(Registration.this);
                    StringRequest sr = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> param = new HashMap<String, String>();
                            param.put("Name",name);
                            param.put("Username",user);
                            param.put("Email",email);
                            param.put("Password",pass);
                            param.put("UserType",usert);
                            return super.getParams();
                        }
                    };
                }
                else
                    Toast.makeText(Registration.this,"Fill all the fields before Registering",Toast.LENGTH_LONG).show();
            }
        });
    }
}