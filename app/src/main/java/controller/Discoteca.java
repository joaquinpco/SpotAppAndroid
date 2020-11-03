package controller;

import java.util.Collections;
import java.util.ArrayList;

public class Discoteca {

    private String _sNombre;
    private String _sCiudad;
    private String _sImagen;
    private double _dLatitud;
    private double _dLongitud;
    private int _iIdProvincia;

    /**
     *
     * @param sNombre Nombre de la discoteca
     * @param sCiudad Ciudad donde se encuentra
     * @param sImagen Imagen de perfil
     * @param dLatitud Latitud en el mapa cartesiano
     * @param dLongitud Longitud en el mapa cartesiano
     * @param iIdProvincia Identificador de la provincia de dicha discoteca
     */
    public Discoteca(String sNombre, String sCiudad, String sImagen, double dLatitud, double dLongitud,
                     int iIdProvincia)
    {
        setNombre(sNombre);
        setCiudad(sCiudad);
        setImagen(sImagen);
        setLatitud(dLatitud);
        setdLongitud(dLongitud);
        setIdProvincia(iIdProvincia);
    }

    public Discoteca(){}


    public String getcNombreDisco() { return _sNombre; }

    public void setNombre(String sNombre) { _sNombre = sNombre; }

    public String getCiudad() { return _sCiudad; }

    public void setCiudad(String sCiudad) { _sCiudad = sCiudad; }

    public String getImagen() { return _sImagen; }

    public void setImagen(String sImagen) { _sImagen = sImagen; }

    public double getLatitud() { return _dLatitud; }

    public void setLatitud(double dLatitud) { _dLatitud = dLatitud; }

    public double getLongitud() { return _dLongitud; }

    public void setdLongitud(double dLongitud) { _dLongitud = dLongitud; }

    public int getIdProvincia() { return _iIdProvincia; }

    public void setIdProvincia(int iIdProvincia) { _iIdProvincia = iIdProvincia; }

}
