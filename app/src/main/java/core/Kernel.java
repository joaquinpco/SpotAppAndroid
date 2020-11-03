package core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import controller.AsyncTasks.ProvinciasData;
import controller.HorizontalReciclerView.RecyclerViewDataAdapter;
import controller.HorizontalReciclerView.SectionDataModel;
import controller.HorizontalReciclerView.SingleItemModel;
import io.realm.Realm;

import io.realm.RealmResults;
import model.firebase.DiscotecaFb;
import model.firebase.RealmModel.DiscotecaRealm;
import model.firebase.RealmModel.ProvinciasRealm;

/**
 * @author joaquinpco
 * @version 1.0
 */
public class Kernel {

    public static Kernel oCore = null;
    private DatabaseReference oRef;
    public static ArrayList<SectionDataModel> allProvinces = new ArrayList<SectionDataModel>();

    /**
     *
     * @return Nueva instancia de la clase Kernel o una existente
     */
    public static Kernel getInstance()
    {
        return oCore == null ? new Kernel() : oCore;
    }

    /**
     * Función para obtener el entero asociado a la fecha
     *
     * @param mes
     * @return Devuelve el número de més segun la cadena de més introducida
     */
    int devuelveMes(String mes)
    {
        String aMonths[] = new String[13];
        aMonths[0] = "" ;
        aMonths[1] = "Enero";
        aMonths[2] = "Febrero";
        aMonths[3] = "Marzo";
        aMonths[4] = "Abril";
        aMonths[5] = "Mayo";
        aMonths[6] = "Junio";
        aMonths[7] = "Julio";
        aMonths[8] = "Agosto";
        aMonths[9] = "Septiembre";
        aMonths[10] = "Octubre";
        aMonths[11] = "Noviembre";
        aMonths[12] = "Diciembre";

        int cont=0;
        for (String m:aMonths) {
            ++cont;
            if(m.equalsIgnoreCase(mes))
            {
                break;//Cuando encontramos el més salimos del bucle
            }
        }
        return cont;
    }

    /**
     * Obtenemos Los Datos de Firebase y  lo almacenamos en RealmDB
     *
     * @throws IOException
     */
    public void devuelveDatosDiscos(final RecyclerView oRv,
                                    final Context context) throws IOException
    {

        oRef = FirebaseDatabase.getInstance().getReference().child("discotecas");

        oRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {

                Realm oRealm = Realm.getDefaultInstance();


                DiscotecaFb oDiscotecaFb = new DiscotecaFb();

                //Comienza la transacción
                oRealm.beginTransaction();

                DiscotecaRealm oDiscotecaRealm = new DiscotecaRealm();

                oDiscotecaRealm.setUUID(UUID.randomUUID().toString());

                for (DataSnapshot childSnapshot: dataSnapshot.getChildren())
                {

                    if (childSnapshot.getKey().equals("ciudad")) {
                        oDiscotecaFb.sCiudad = (String) childSnapshot.getValue();
                        oDiscotecaRealm.setCiudad(oDiscotecaFb.sCiudad);
                        String sCiudad = oDiscotecaRealm.getCiudad();
                    } else if (childSnapshot.getKey().equals("longitud")) {
                        Object o = childSnapshot.getValue();
                        oDiscotecaFb.dLongitud = Double.parseDouble(o.toString());
                        oDiscotecaRealm.setLongitud(oDiscotecaFb.dLongitud);
                        double dLongitud = oDiscotecaRealm.getLongitud();
                    } else if (childSnapshot.getKey().equals("latitud")) {
                        Object o = childSnapshot.getValue();
                        oDiscotecaFb.dLatitud = Double.parseDouble(o.toString());
                        oDiscotecaRealm.setLatitud(oDiscotecaFb.dLatitud);
                        double dLatitud = oDiscotecaRealm.getLatitud();
                    } else if (childSnapshot.getKey().equals("imagen")) {
                        oDiscotecaFb.sImagen = (String) childSnapshot.getValue();
                        oDiscotecaRealm.setImagen(oDiscotecaFb.sImagen);
                        String sImagen = oDiscotecaRealm.getImagen();
                    } else if (childSnapshot.getKey().equals("id_provincia")) {
                        Object o = childSnapshot.getValue();
                        oDiscotecaFb.iIdProvincia = Integer.parseInt(o.toString());
                        oDiscotecaRealm.setIdProvincia(oDiscotecaFb.iIdProvincia);
                        int iIdProvincia = oDiscotecaRealm.getIdProvincia();
                    } else if (childSnapshot.getKey().equals("id_Discoteca")) {
                        Object o = childSnapshot.getValue();
                        oDiscotecaFb.iIdDiscoteca = Integer.valueOf(o.toString());
                        oDiscotecaRealm.setIdDiscoteca(oDiscotecaFb.iIdDiscoteca);
                        int iIdDiscoteca = oDiscotecaRealm.getIdDiscoteca();
                    } else if (childSnapshot.getKey().equals("nombre")) {
                        oDiscotecaFb.sNombre = (String) childSnapshot.getValue();
                        oDiscotecaRealm.setNombre(oDiscotecaFb.sNombre);
                        String sNombre = oDiscotecaRealm.getNombre();
                    } else {}
                }

                oRealm.copyToRealm(oDiscotecaRealm);
                oRealm.commitTransaction();
                //Fin de la transacción
                Log.d("info", "Info");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        oRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Lanzamos el actualizador de la BBDD
                fillUIProvincesWithDiscos();
                oRv.setAdapter(new RecyclerViewDataAdapter(context,
                        allProvinces));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * Sólo se invoca una vez para rellenar las 50 provincias
     */
    public void guardaroNoProvinciasEnRealmDB()
    {
        //Creamos objeto local para realm.
        Realm oRealm = Realm.getDefaultInstance();

        //En caso de que se llame más de una vez, no se realizará.
        if(oRealm.where(ProvinciasRealm.class).count() == 0)
        {

            try
            {
                /*
                    En primer lugar se descargará los datos
                    En segundo lugar se insertarán secuencialmente
                 */
                new ProvinciasData().execute();
            }
            catch (Exception ex) {}
        }
    }

    /**
     * Cierra la sesión del usuario
     */
    public void signOut()
    {
        FirebaseAuth.getInstance().signOut();
    }

    /**
     *
     * @return Perfil de usuario de Google
     */
    public FirebaseUser getProfileFromGoogle()
    {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    /**
     * Recorre las Discotecas respecto a su provincia RealmDB
     * <h1>Rellenar las provincias.</h1>
     * <h2>Rellena las discos dentro de sus provincias.</h2>
     */
    public void fillUIProvincesWithDiscos()
    {
        //Creamos el objeto oRealm
        Realm oRealm = Realm.getDefaultInstance();

        RealmResults<ProvinciasRealm> oProvinciasResult = oRealm.where(ProvinciasRealm.class)
                .findAll();
        if(oProvinciasResult.size() != 0)
        {
            //Recorremos las provincias
            for (ProvinciasRealm oProvincia : oProvinciasResult)
            {
                SectionDataModel oSdm = new SectionDataModel();
                int iIdProvincia = Integer.parseInt(oProvincia.getIdProvincia().toString());
                String sNombre = oProvincia.getNombre();
                ArrayList<SingleItemModel> aSim = new ArrayList<SingleItemModel>();

                //Modificamos el titulo de la cabecera
                oSdm.setHeaderTitle(sNombre);

                RealmResults<DiscotecaRealm> oDiscosResult = oRealm.
                        where(DiscotecaRealm.class)
                        .equalTo("_iIdProvincia", iIdProvincia).findAll();

                for (DiscotecaRealm oDiscoteca : oDiscosResult)
                    aSim.add(new SingleItemModel(oDiscoteca.getNombre().toString(),
                            oDiscoteca.getImagen().toString()));


                if(oDiscosResult.size() > 0) {
                    oSdm.setAllItemsInSection(aSim);
                    allProvinces.add(oSdm);
                    Log.d("Error Data", "erro");
                }
            }
        }
    }
}
