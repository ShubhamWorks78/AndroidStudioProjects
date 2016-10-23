package com.seals.shubham.ecommerce;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by shubham on 7/4/2016.
 */
public class customRequest extends Request<JSONArray>{
    private Response.Listener<JSONArray> listener;
    private Map<String,String> params;

    public customRequest(String url, Map<String,String> params, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener)
    {
        super(Method.GET,url,errorListener);
        this.listener = listener;
        this.params = params;
    }
    public customRequest(int method, String url, Map<String,String> params, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener)
    {
        super(method,url,errorListener);
        this.listener = listener;
        this.params = params;
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
        try{
            String jsonString = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(new JSONArray(jsonString),HttpHeaderParser.parseCacheHeaders(networkResponse));
        }
        catch (UnsupportedEncodingException e)
        {
            return Response.error(new ParseError(e));
        }
        catch(JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
    @Override
    protected void deliverResponse(JSONArray jsonArray) {
        listener.onResponse(jsonArray);
    }
}