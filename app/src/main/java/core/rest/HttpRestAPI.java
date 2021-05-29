package core.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class HttpRestAPI implements API{

    public static HttpRestAPI httpRest = null;

    private HttpRestAPI() {}

    public static HttpRestAPI getInstance() {
        return httpRest == null ? new HttpRestAPI() : httpRest;
    }

    @Override
    public void GET(String url, Context context) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(response);
                }
                catch (Exception ex){}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public JsonArrayRequest GET(String url, Context context, String... params) {
        return null;
    }

    @Override
    public JsonArrayRequest POST(String url, Context context, String... params) {
        return null;
    }
}
