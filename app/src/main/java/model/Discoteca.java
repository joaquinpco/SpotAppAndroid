package model;

import java.io.Serializable;
import java.util.Objects;

public class Discoteca implements Serializable {

    private String nombre;
    private String ciudad;
    private String imagen;
    private double latitud;
    private double longitud;
    private int idProvincia;

    public Discoteca(String sNombre, String sCiudad, String sImagen, double dLatitud,
                     double dLongitud, int iIdProvincia) {
        setNombre(sNombre);
        setCiudad(sCiudad);
        setImagen(sImagen);
        setLatitud(dLatitud);
        setdLongitud(dLongitud);
        setIdProvincia(iIdProvincia);
    }

    public Discoteca() {}

    public String getcNombreDisco() { return this.nombre; }
    public String getCiudad() { return this.ciudad; }
    public String getImagen() { return this.imagen; }
    public double getLatitud() { return this.latitud; }
    public double getLongitud() { return this.longitud; }
    public int getIdProvincia() { return this.idProvincia; }

    public void setNombre(String sNombre) { this.nombre = sNombre; }
    public void setCiudad(String sCiudad) { this.ciudad = sCiudad; }
    public void setImagen(String sImagen) { this.imagen = sImagen; }
    public void setLatitud(double dLatitud) { this.latitud = dLatitud; }
    public void setdLongitud(double dLongitud) { this.longitud = dLongitud; }
    public void setIdProvincia(int iIdProvincia) { this.idProvincia = iIdProvincia; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discoteca discoteca = (Discoteca) o;
        return Double.compare(discoteca.latitud, latitud) == 0 &&
                Double.compare(discoteca.longitud, longitud) == 0 &&
                idProvincia == discoteca.idProvincia &&
                Objects.equals(nombre, discoteca.nombre) &&
                Objects.equals(ciudad, discoteca.ciudad) &&
                Objects.equals(imagen, discoteca.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ciudad, imagen, latitud, longitud, idProvincia);
    }

    @Override
    public String toString() {
        return "Discoteca=[ nombre=" + this.nombre+ ", ciudad=" + this.ciudad + ", imagen="
                + this.imagen +
                ", latitud=" + this.latitud + ", longitud=" + this.longitud + ", idProvincia=" +
                this.idProvincia + "]";
    }

}
