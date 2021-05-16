package core;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
    public FirebaseUser getProfileFromGoogle() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }
}
