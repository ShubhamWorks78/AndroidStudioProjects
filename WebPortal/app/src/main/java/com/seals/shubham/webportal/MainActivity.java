package com.seals.shubham.webportal;

import android.content.Intent;
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
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText usr,pas;
    Button log;
    String url = "http://shubhamshanky.coolpage.biz/ChckLogin.php";
    TextView frge,reg;
    CheckBox cb;
    String user,pass;
    RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb = (CheckBox)findViewById(R.id.ShwPass);
        usr = (EditText)findViewById(R.id.LogUser);
        pas = (EditText)findViewById(R.id.LogPass);
        log = (Button)findViewById(R.id.BtnLog);
        frge = (TextView) findViewById(R.id.TxtFrgtPass);
        mQueue = Volley.newRequestQueue(MainActivity.this);
        reg = (TextView)findViewById(R.id.TxtRegisterPage);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Registration.class);
                startActivity(i);
            }
        });
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    pas.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
                }
                else
                    pas.setInputType(129);
            }
        });
        frge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ForgetPass.class);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                user = usr.getText().toString();
                pass = pas.getText().toString();
                JsonArrayRequest array = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for(int i=0;i<jsonArray.length();i++)
                        {
                            try {
                                JSONObject jsonObj = jsonArray.getJSONObject(i);
                                String urs,psa;
                                urs = jsonObj.getString("Username");
                                psa = jsonObj.getString("Password");
                                if(user.equals(urs) && pass.equals(psa))
                                {
                                    String type = jsonObj.getString("UserType");
                                    changeActivity(type);
                                    break;
                                }
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
                mQueue.add(array);
            }
        });
}
    public void changeActivity(String type)
    {
        if(type.equals("User"))
        {
            Intent i = new Intent(MainActivity.this,UserPage.class);
            startActivity(i);
        }
        else if(type.equals("Admin"))
        {
            Intent i = new Intent(MainActivity.this,AdminPage.class);
            startActivity(i);
        }
    }
}