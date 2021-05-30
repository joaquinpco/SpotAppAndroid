package akeen.app.SpotApp.Discotecas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import akeen.app.SpotApp.R;
import core.Utils;

public class DiscosFragment extends Fragment {

    public static ProgressBar oProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_discos, container, false);

        Utils.getInstance().setPermisionsForSDKGreaterThanNine();

        try{
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    getResources().getString(R.string.api_discos_endpoint),
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d("Array", response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            );

            Volley.newRequestQueue(getContext()).add(jsonArrayRequest);

            RecyclerView my_recycler_view = (RecyclerView) v.findViewById(R.id.my_recycler_view);
            my_recycler_view.setHasFixedSize(true);
            my_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false));
        }
        catch(Exception error) {}

        return v;
    }
}
