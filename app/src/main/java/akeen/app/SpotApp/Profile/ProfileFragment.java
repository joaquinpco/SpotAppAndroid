package akeen.app.SpotApp.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import akeen.app.SpotApp.R;
import core.Utils;

public class ProfileFragment extends Fragment
{
    private ImageView _oImgView;
    private TextView _oTxtNameLastName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

        View oView = inflater.inflate(R.layout.fragment_profile, container, false);

        FirebaseUser oFBUser = Utils.getInstance().getProfileFromGoogle();

        //Instatiate UI/UX
        _oImgView = (ImageView) oView.findViewById(R.id.imgProfile);
        _oTxtNameLastName = (TextView) oView.findViewById(R.id.txtUsername);

        //Set Atrbts,
        _oTxtNameLastName.setText(oFBUser.getDisplayName());
        Picasso.get().load(oFBUser.getPhotoUrl()).into(_oImgView);
        return oView;
    }
}
