package core;

import android.os.StrictMode;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;

/**
 * @author joaquinpco
 * @version 1.0
 */
public class Utils {
    public static Utils oCore = null;

    private Utils() {}

    public static Utils getInstance()
    {
        return oCore == null ? new Utils() : oCore;
    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    public void setPermisionsForSDKGreaterThanNine() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public FirebaseUser getProfileFromGoogle() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }
}
