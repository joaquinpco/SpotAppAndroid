package akeen.app.SpotApp.BarraNavegacionInferior;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import akeen.app.SpotApp.Discotecas.DiscosFragment;
import akeen.app.SpotApp.Profile.ProfileFragment;
import akeen.app.SpotApp.R;

public class BottomNavigationVw extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener
{

    private final Integer TOOLBAR_TITLE = 0;
    private final Integer PACKAGE_CLASS_NAME = 1;

    private BottomNavigationView bottomNavigationView;
    private DiscosFragment discosFragment;
    private ProfileFragment profileFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationView);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_clubbing);
    }

    /**
     *
     * @param fragment Fragmento a agregar a nuestro container
     */
    private void openFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        String toolbarTitle = getToolbarTitleOrPackageClassName(menuItem)[TOOLBAR_TITLE];
        toolbar.setTitle(toolbarTitle);
        String packageClassName = getToolbarTitleOrPackageClassName(menuItem)[PACKAGE_CLASS_NAME];
        changeFragmentFromPackageClassName(packageClassName);

        return false;
    }

    private String[] getToolbarTitleOrPackageClassName(MenuItem menuItem) {
        String toolbarTitleOrPackageClassName[] = new String[2];

        switch (menuItem.getItemId()) {
            case R.id.navigation_clubbing:
                toolbarTitleOrPackageClassName[TOOLBAR_TITLE] = "Clubbing";
                toolbarTitleOrPackageClassName[
                    PACKAGE_CLASS_NAME
                ] = "akeen.app.SpotApp.Discotecas.DiscosFragment";
                break;
            case R.id.navigation_events:
                toolbarTitleOrPackageClassName[TOOLBAR_TITLE] = "Events";
                toolbarTitleOrPackageClassName[PACKAGE_CLASS_NAME] = "";
                break;
            case R.id.navigation_profile:
                toolbarTitleOrPackageClassName[TOOLBAR_TITLE] = "Profile";
                toolbarTitleOrPackageClassName[
                    PACKAGE_CLASS_NAME
                ] = "akeen.app.SpotApp.Profile.ProfileFragment";
                break;
        }



        return toolbarTitleOrPackageClassName;
    }

    private void changeFragmentFromPackageClassName(String toolbarTitle) {

        try{
            Fragment fragment = (Fragment)(Class.forName(toolbarTitle).newInstance());
            openFragment(fragment);
        }catch(ClassNotFoundException e){
            Log.e("loading level","level class not found",e);
        }
        catch (Exception e) {}
    }
}
