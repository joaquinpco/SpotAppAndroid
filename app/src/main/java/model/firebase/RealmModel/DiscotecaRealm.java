package model.firebase.RealmModel;

import controller.Discoteca;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DiscotecaRealm extends RealmObject
{

    private Integer _iIdDiscoteca;
    private String _sCiudad, _sImagen, _sNombre;
    private Double _dLongitud, _dLatitud;
    private Integer _iIdProvincia;

    //Cada Discoteca tiene una provincia asociada.(Relación 1:1)
    private ProvinciasRealm _oProvincias;

    @PrimaryKey
    private String _uuid;

    public DiscotecaRealm() {}

    public String getCiudad() { return _sCiudad; }
    public String getImagen() { return _sImagen; }
    public String getNombre() { return _sNombre; }
    public Double getLongitud() { return _dLongitud; }
    public Double getLatitud() { return _dLatitud; }
    public Integer getIdProvincia() { return _iIdProvincia; }
    public Integer getIdDiscoteca() { return _iIdDiscoteca; }
    public ProvinciasRealm getProvincia() { return _oProvincias; }

    public void setProvinciaRealm(ProvinciasRealm oProvincias) { _oProvincias = oProvincias; }
    public void setCiudad(String sCiudad) { _sCiudad = sCiudad; }
    public void setImagen(String sImagen) { _sImagen = sImagen; }
    public void setNombre(String sNombre) { _sNombre = sNombre; }
    public void setLongitud(Double dLongitud) { _dLongitud = dLongitud; }
    public void setLatitud(Double dLatitud) { _dLatitud = dLatitud; }
    public void setIdProvincia(Integer iIdProvincia) { _iIdProvincia = iIdProvincia; }
    public void setIdDiscoteca(Integer iIdDiscoteca) { _iIdDiscoteca = iIdDiscoteca; }
    public void setUUID(String uuid) { _uuid = uuid; }

}
