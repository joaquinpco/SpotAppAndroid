package controller.AsyncTasks;

import android.os.AsyncTask;

/**
 * @author https://github.com/guilogar
 */
public class API extends AsyncTask<Void, Void, String> {

    private String url;
    private int responseCode = 0;

    public API(String url) { this.url = url; }

    public int getResponseCode() { return this.responseCode; }
    public void setResponseCode(int code) { this.responseCode = code; }
    public String getUrl() { return this.url; }

    protected String doInBackground(Void... params) {
        return null;
    }
}
