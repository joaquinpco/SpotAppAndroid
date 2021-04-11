package controller.AsyncTasks;

import android.os.AsyncTask;

public class ProvinciasData extends AsyncTask<Void, Void, Void>
{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        //No se devuelve nada ya que es vacío
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
