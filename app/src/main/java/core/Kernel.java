package core;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;

import controller.HorizontalReciclerView.SectionDataModel;

/**
 * @author joaquinpco
 * @version 1.0
 */
public class Kernel {

    public static Kernel oCore = null;

    public static Kernel getInstance()
    {
        return oCore == null ? new Kernel() : oCore;
    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    public FirebaseUser getProfileFromGoogle() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }
}
