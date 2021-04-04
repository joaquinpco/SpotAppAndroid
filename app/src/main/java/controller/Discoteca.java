package controller;

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
                     int iIdProvincia) {
        setNombre(sNombre);
        setCiudad(sCiudad);
        setImagen(sImagen);
        setLatitud(dLatitud);
        setdLongitud(dLongitud);
        setIdProvincia(iIdProvincia);
    }

    public Discoteca() {}

    public String getcNombreDisco() { return _sNombre; }
    public String getCiudad() { return _sCiudad; }
    public String getImagen() { return _sImagen; }
    public double getLatitud() { return _dLatitud; }
    public double getLongitud() { return _dLongitud; }
    public int getIdProvincia() { return _iIdProvincia; }

    public void setNombre(String sNombre) { _sNombre = sNombre; }
    public void setCiudad(String sCiudad) { _sCiudad = sCiudad; }
    public void setImagen(String sImagen) { _sImagen = sImagen; }
    public void setLatitud(double dLatitud) { _dLatitud = dLatitud; }
    public void setdLongitud(double dLongitud) { _dLongitud = dLongitud; }
    public void setIdProvincia(int iIdProvincia) { _iIdProvincia = iIdProvincia; }

    @Override
    public String toString() {
        return "Discoteca=[ nombre=" + _sNombre+ ", ciudad=" + _sCiudad + ", imagen=" + _sImagen +
                ", latitud=" + _dLatitud + ", longitud=" + _dLongitud + ", idProvincia=" +
                _iIdProvincia + "]";
    }

}
