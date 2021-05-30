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
    private ImageView profileImageView;
    private TextView fullNameTextView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        fillUIwithFirebaseData();
        return view;
    }

    private void fillUIwithFirebaseData() {
        FirebaseUser oFBUser = Utils.getInstance().getProfileFromGoogle();
        profileImageView = (ImageView) view.findViewById(R.id.imgProfile);
        fullNameTextView = (TextView) view.findViewById(R.id.txtUsername);
        fullNameTextView.setText(oFBUser.getDisplayName());
        Picasso.get().load(oFBUser.getPhotoUrl()).into(profileImageView);
    }
}
