package com.seals.shubham.jsonobjectrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //Here we will get the name of the nearby restraunt and represent it in the Toast
    //First add volley.jar file
    RequestQueue reqQ;
    String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=28.5806201,77.3150729&radius=500&types=food&key=AIzaSyASmpU_1YTZH9jwTbDdGU5IR8RWz4l8QEc\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reqQ = Volley.newRequestQueue(this);
        JsonObjectRequest jOR = new JsonObjectRequest(url,new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                try {
                    //We are storing the result of the JSon object in a jsonArray.
                    //Here 'results' is the name of the JSON Object in the Json file
                    JSONArray myArray = jsonObject.getJSONArray("results");
                    for(int i=0;i<myArray.length();i++)
                    {
                        JSONObject myData = myArray.getJSONObject(i);
                        //Getting the Inner Json Object of jsonArray
                        String ss = myData.getString("name");
                        //For getting the name of the Restraunts or Places
                        Toast.makeText(MainActivity.this,""+ss,Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        reqQ.add(jOR);
    }
}
