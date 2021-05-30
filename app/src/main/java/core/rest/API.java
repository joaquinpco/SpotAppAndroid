package core.rest;

import android.content.Context;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

public interface API {
    public void GET(String url, Context context, final HttpRestAPI.VolleyCallback volleyCallback);
    public JsonArrayRequest GET(
            String url, Context context,
            final HttpRestAPI.VolleyCallback callback, String ... params
    );
    public JsonArrayRequest POST(
            String url, Context context,
            final HttpRestAPI.VolleyCallback callback ,String ... params);
}
