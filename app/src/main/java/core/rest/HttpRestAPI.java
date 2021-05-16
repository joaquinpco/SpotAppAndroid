package core.rest;

import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;

public class HttpRestAPI implements API{

    public static HttpRestAPI httpRest = null;

    private static HttpRestAPI getInstance() {
        return httpRest == null ? new HttpRestAPI() : httpRest;
    }

    @Override
    public JsonArrayRequest GET(String url) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("Resultado: ", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error: ", error.getMessage());
                    }
                }
        );
        return jsonArrayRequest;
    }

    @Override
    public JsonArrayRequest GET(String url, String... params) {
        return null;
    }

    @Override
    public JsonArrayRequest POST(String url, String... params) {
        return null;
    }
}
