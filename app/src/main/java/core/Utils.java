package core;

import android.os.StrictMode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Utils {
    public static Utils oCore = null;

    private Utils() {}

    public static Utils getInstance()
    {
        return oCore == null ? new Utils() : oCore;
    }

    public void setPermisionsForSDKGreaterThanNine() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void signOut() { FirebaseAuth.getInstance().signOut(); }
    public FirebaseUser getProfileFromGoogle() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public void setThreadPolicyPermissions() {
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
