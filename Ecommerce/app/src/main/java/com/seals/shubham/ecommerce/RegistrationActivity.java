package com.seals.shubham.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewConfiguration;
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

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    EditText usr,pas,ema,nam;
    AutoCompleteTextView type;
    TextView logP;
    Button reg;
    String user,pass,name,email,usert;
    String url = "http://shubhamshanky.coolpage.biz/EcommrceRegister.php";
    RequestQueue reqQ;
    String[] data = {"Admin","User"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.wwwicon);
        usr = (EditText)findViewById(R.id.RegUser);
        nam = (EditText)findViewById(R.id.RegName);
        ema = (EditText)findViewById(R.id.RegEmail);
        pas = (EditText)findViewById(R.id.RegPass);
        type = (AutoCompleteTextView)findViewById(R.id.RegType);
        reg = (Button)findViewById(R.id.BtnReg);
        logP = (TextView)findViewById(R.id.TxtLoginPage);
        reqQ = Volley.newRequestQueue(RegistrationActivity.this);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(RegistrationActivity.this,android.R.layout.simple_list_item_1,data);
        type.setThreshold(2);
        type.setAdapter(ad);
        logP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nam.getText().toString();
                user = usr.getText().toString();
                pass = pas.getText().toString();
                email = ema.getText().toString();
                usert = type.getText().toString();
                if(name!=null && user!=null && pass!=null && email!=null && usert!=null)
                {
                    StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            Toast.makeText(RegistrationActivity.this,""+s,Toast.LENGTH_LONG).show();
                            if(s.equals("Success"))
                            {
                                Toast.makeText(RegistrationActivity.this,"You are Successfully Registered",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                                startActivity(i);
                            }
                            else if(s.equals("Failure"))
                            {
                                Toast.makeText(RegistrationActivity.this,"Can't be added..Try Again..",Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("Name",name);
                            params.put("Username",user);
                            params.put("Password",pass);
                            params.put("Email",email);
                            params.put("UserType",usert);
                            return params;
                        }
                    };
                    reqQ.add(strReq);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater men = getMenuInflater();
        men.inflate(R.menu.activity_admin_page_drawer,menu);
        try{
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKey!=null)
            {
                menuKey.setAccessible(true);
                menuKey.setBoolean(config,false);
            }
        }
        catch (Exception e)
        {

        }
        return true;
    }
}