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
import android.view.MenuItem;

import akeen.app.SpotApp.Discotecas.DiscosFragment;
import akeen.app.SpotApp.Profile.ProfileFragment;
import akeen.app.SpotApp.R;

public class BottomNavigationVw extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener
{

    //Declaración de elementos de la interfaz gráfica
    private BottomNavigationView _oBNV;
    private DiscosFragment _oDF;
    private ProfileFragment _oPF;
    private Toolbar _oToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        //Inicialización de elementos de la UI.
        _oBNV = (BottomNavigationView)findViewById(R.id.navigationView);
        _oToolbar = (Toolbar)findViewById(R.id.toolbar);
        _oToolbar.setTitleTextColor(Color.WHITE);

        //Registramos el evento click en los items del menú.
        _oBNV.setOnNavigationItemSelectedListener(this);

        //Por defecto marcamos la vista de las dicotecas
        _oBNV.setSelectedItemId(R.id.navigation_clubbing);

    }

    /**
     * Agregamos nuestro fragmento a la UI.
     *
     * @param oFragmento
     */
    private void openFragment(Fragment oFragmento)
    {
        //Transación de fragmentos
        FragmentTransaction oFT = getSupportFragmentManager().beginTransaction();
        oFT.replace(R.id.container, oFragmento);
        oFT.addToBackStack(null);
        oFT.commit();
    }

    //Aquí cambiaremos de fragmento
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.navigation_clubbing:
                _oToolbar.setTitle("Clubbing");
                openFragment(_oDF == null ? new DiscosFragment() : _oDF);
                    return true;
            case R.id.navigation_events:
                _oToolbar.setTitle("Events");
                    return true;
            case R.id.navigation_profile:
                _oToolbar.setTitle("Profile");
                openFragment(_oPF == null ? new ProfileFragment() : _oPF);
                    return true;
        }
        return false;
    }
}
