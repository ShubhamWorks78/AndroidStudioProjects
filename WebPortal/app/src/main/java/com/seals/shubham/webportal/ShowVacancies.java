package com.seals.shubham.webportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowVacancies extends AppCompatActivity {
    ListView lv;
    List<String> arr;
    String[] arrayOfString;
    String url = "http://shubhamshanky.coolpage.biz/PortalDataFull.php";
    RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_vacancies);
        lv = (ListView)findViewById(R.id.allVacanciesList);
        rq = Volley.newRequestQueue(ShowVacancies.this);
        arr = new ArrayList<String>();
        JsonArrayRequest json = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        arr.add(jsonArray.getString(4)+"\n");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        arrayOfString = arr.toArray(new String[arr.size()]);
        rq.add(json);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(ShowVacancies.this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(ad);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.allVacanciesList)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(arrayOfString[info.position]);
            String[] menuItems = getResources().getStringArray(R.array.MenuItems);
            for(int i=0;i<menuItems.length;i++)
            {
                menu.add(Menu.NONE,i,i,menuItems[i]);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String[] menuItems = getResources().getStringArray(R.array.MenuItems);
        String menuItemName = menuItems[menuItemIndex];
        String listItemName = arrayOfString[info.position];
        if(item.getItemId()==0)
        {
            HashMap<String,String> params = new HashMap<String, String>();
            params.put("Company",listItemName);
            Volley.newRequestQueue(ShowVacancies.this).add(new JsonRequest<JSONArray>(Request.Method.POST, url,(new JSONObject(params)).toString(), new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray jsonArray) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {

                }
            }) {
                @Override
                protected Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
                    return null;
                }
            });

        }
        else if(item.getItemId()==1)
        {

        }
        else if(item.getItemId()==2)
        {

        }
        return true;
    }
}
