package com.seals.shubham.webportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    EditText nam,usr,pass,ema;
    AutoCompleteTextView usrt;
    String Data[] = {"User","Admin"};
    Button reg;
    String url = "http://shubhamshanky.coolpage.biz/InsertPortal.php";
    String name,user,passw,email,usert;
    TextView log;
    RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        nam = (EditText)findViewById(R.id.RegName);
        usr = (EditText)findViewById(R.id.RegUser);
        pass = (EditText)findViewById(R.id.RegPass);
        ema = (EditText)findViewById(R.id.RegEmail);
        usrt = (AutoCompleteTextView) findViewById(R.id.RegType);
        reg = (Button)findViewById(R.id.BtnReg);
        log = (TextView)findViewById(R.id.TxtLoginPage);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(Registration.this,android.R.layout.simple_list_item_1,Data);
        usrt.setThreshold(2);
        mRequestQueue = Volley.newRequestQueue(this);
        usrt.setAdapter(ad);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registration.this,MainActivity.class);
                startActivity(i);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nam.getText().toString();
                user = usr.getText().toString();
                passw = pass.getText().toString();
                email = ema.getText().toString();
                usert = usrt.getText().toString();
                if(name!=null && user!=null && passw!=null && email!=null && usert!=null)
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            Toast.makeText(Registration.this,""+s,Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(Registration.this,""+volleyError,Toast.LENGTH_LONG).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> param = new HashMap<String, String>();
                            param.put("Name",name);
                            param.put("Username",user);
                            param.put("Password",passw);
                            param.put("Email",email);
                            param.put("UserType",usert);
                            return param;
                        }
                    };
                    mRequestQueue.add(stringRequest);
                    nam.setText("");
                    usr.setText("");
                    pass.setText("");
                    usrt.setText("");
                    ema.setText("");
                 }
            }
        });
    }
}
