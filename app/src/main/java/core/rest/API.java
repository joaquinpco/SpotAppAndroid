package core.rest;

import com.android.volley.toolbox.JsonArrayRequest;

public interface API {
    public JsonArrayRequest GET(String url);
    public JsonArrayRequest GET(String url, String ... params);
    public JsonArrayRequest POST(String url, String ... params);
}
