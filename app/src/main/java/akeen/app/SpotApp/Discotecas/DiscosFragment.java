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

public class DiscosFragment extends Fragment {

    public static ProgressBar oProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_discos, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Obtenemos las discotecas desde firebase en el arraylist estático.
        try{
            //Inicializamos RealmDB,esto solo se realizará una vez.
            //Kernel.getInstance().fillUIProvincesWithDiscos()

            RecyclerView my_recycler_view = (RecyclerView) v.findViewById(R.id.my_recycler_view);
            my_recycler_view.setHasFixedSize(true);
            my_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false));
        }
        catch(Exception error) {}

        return v;
    }
}
