package model.firebase.RealmModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProvinciasRealm extends RealmObject
{
    private String _sNombre;

    @PrimaryKey
    private Integer _iIdProvincia;

    //Getters y Setters
    public void setNombre(String sNombre) { _sNombre = sNombre; }
    public String getNombre() { return _sNombre; }
    public void setIdProvincia(Integer iIdProvincia) { _iIdProvincia = iIdProvincia; }
    public Integer getIdProvincia() { return _iIdProvincia; }


}
