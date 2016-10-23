package com.seals.shubham.ecommerce;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView frge,reg;
    EditText user,pass;
    String usr,pas,userTyp;
    CheckBox cb;
    Button log;
    String url = "http://shubhamshanky.coolpage.biz/EcommerceLogin.php";
    RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText)findViewById(R.id.LogUser);
        pass = (EditText)findViewById(R.id.LogPass);
        frge = (TextView)findViewById(R.id.TxtFrgtPass);
        cb = (CheckBox)findViewById(R.id.ShwPass);
        log = (Button)findViewById(R.id.BtnLog);
        rq = Volley.newRequestQueue(MainActivity.this);
        reg = (TextView)findViewById(R.id.TxtRegisterPage);
        frge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ForgetPass.class);
                startActivity(i);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usr = user.getText().toString();
                pas = pass.getText().toString();
                if(usr.equals(pas))
                {
                    Intent i = new Intent(MainActivity.this,UserPage.class);
                    startActivity(i);
                }
                HashMap<String,String> param = new HashMap<String, String>();
                param.put("Username",usr);
                param.put("Password",pas);
                customRequest cust = new customRequest(Request.Method.POST, url, param, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonObject) {
                        try {
                            JSONObject jsc = jsonObject.getJSONObject(0);
                            String usertype = jsc.getString("UserType");
                            if(usertype.equals("Admin"))
                            {
                                Intent i = new Intent(MainActivity.this,AdminPage.class);
                                startActivity(i);
                            }
                            else if(usertype.equals("User"))
                            {
                                Intent i = new Intent(MainActivity.this,UserPage.class);
                                startActivity(i);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i=0;i<jsonObject.length();i++)
                        {
                            try {
                                JSONObject jso = jsonObject.getJSONObject(i);
                                String type = jso.getString(usr);
                                Toast.makeText(MainActivity.this,""+type,Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this,""+volleyError,Toast.LENGTH_LONG).show();
                    }
                });
                Volley.newRequestQueue(MainActivity.this).add(cust);
            }
        });
    }
}
