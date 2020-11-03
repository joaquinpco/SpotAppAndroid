package controller.AsyncTasks;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import core.Kernel;
import io.realm.Realm;
import model.firebase.RealmModel.ProvinciasRealm;

public class ProvinciasData extends AsyncTask<Void, Void, Void>
{

    private String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            Realm oRealm = Realm.getDefaultInstance();

            String sResponse = "";

            //String url provincias de españa
            String sUrl = "https://gist.githubusercontent.com/AitorG/" +
                    "56492b62641d083a93c2/raw/";

            //Pasamos la URL del objeto a consultar
            URL url = new URL(sUrl);
            HttpURLConnection oConn = (HttpURLConnection) url.openConnection();
            oConn.setRequestMethod("GET");

            // Leemos lo devuelto
            InputStream in = new BufferedInputStream(oConn.getInputStream());

            // Obtenemos la respuesta
            sResponse = convertStreamToString(in);

            if(sResponse != null)
            {

                //Obtenemos el nodo del array JSON
                JSONArray oJSONArray = new JSONArray(sResponse);

                //recorremos el archivo JSON
                for (int i = 0; i < oJSONArray.length(); i++)
                {
                    JSONObject oObjetoActual = oJSONArray.getJSONObject(i);

                    //Obtenemos los dos campos.
                    int iId_provincia = oObjetoActual.getInt("id");
                    String sName = oObjetoActual.getString("name");

                    //Objeto Provincias de RealmDB
                    ProvinciasRealm oPR = new ProvinciasRealm();
                    oPR.setIdProvincia(iId_provincia);
                    oPR.setNombre(sName);

                    //Procedemos a la inserción en Realm
                    oRealm.beginTransaction();
                    oRealm.copyToRealmOrUpdate(oPR);
                    oRealm.commitTransaction();
                }

            }

        }catch (Exception exc) {}

        //No se devuelve nada ya que es vacío
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
