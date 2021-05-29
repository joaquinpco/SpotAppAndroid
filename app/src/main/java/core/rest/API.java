package core.rest;

import android.content.Context;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

public interface API {
    public void GET(String url, Context context);
    public JsonArrayRequest GET(String url, Context context, String ... params);
    public JsonArrayRequest POST(String url, Context context, String ... params);
}
