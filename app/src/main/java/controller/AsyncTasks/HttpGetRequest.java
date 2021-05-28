package controller.AsyncTasks;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.net.URL;

import android.content.Context;

public class HttpGetRequest extends AsyncTaskLoader<String>{

    private String url;
    private Context context;
    private int responseCode = 0;

    public HttpGetRequest(String url, Context context) {
        super(context);
        this.context = context;
        this.url = url;
    }

    public int getResponseCode() { return this.responseCode; }
    public void setResponseCode(int code) { this.responseCode = code; }
    public String getUrl() { return this.url; }


    @Override
    public String loadInBackground() {
        return null;
    }
}
