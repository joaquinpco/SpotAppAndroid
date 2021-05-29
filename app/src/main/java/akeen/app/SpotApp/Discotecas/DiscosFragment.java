package akeen.app.SpotApp.Discotecas;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import akeen.app.SpotApp.R;
import core.Utils;
import core.rest.HttpRestAPI;
import okhttp3.internal.Util;

public class DiscosFragment extends Fragment {

    public static ProgressBar oProgressBar;
    private HttpRestAPI httpRestAPI;
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        this.v = inflater.inflate(R.layout.fragment_discos, container, false);
        try{
            Utils.getInstance().setThreadPolicyPermissions();
            getClubsAndStorageIntoRealm();
        }
        catch(Exception error) {}

        return v;
    }

    private void getClubsAndStorageIntoRealm() {
        HttpRestAPI.getInstance().GetClubsAndInsertIntoRealmDB(
                getResources().getString(R.string.clubs_endpoint),
                getContext()
        );
    }

    private void makeRecyclerViewFromRealmDB() {
        RecyclerView my_recycler_view = (RecyclerView) this.v.findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }
}
