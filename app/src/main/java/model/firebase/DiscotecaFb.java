package model.firebase;

/**
 * Created by joaquinpco on 12/2/18.
 */
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DiscotecaFb {

    public String sCiudad,sImagen,sNombre;
    public Double dLongitud, dLatitud;
    public Integer iIdProvincia, iIdDiscoteca;

    public DiscotecaFb(){}

    /**
     *
     * @param sCiudad Ciudad de origen de la discoteca
     * @param iIdDiscoteca Identificador de la discoteca
     * @param iIdProvincia Identificador de la Provincia
     * @param sImagen Imagen de perfil de la discoteca
     * @param dLatitud Latitud en el mapa cartesiano
     * @param dLongitud Longitud en el mapa cartesiano
     * @param sNombre Nombre en el mapa cartesiano
     */
    public DiscotecaFb(double dLatitud, double dLongitud, String sCiudad, String sImagen,
                       int iIdProvincia, String sNombre, int iIdDiscoteca)
    {
        this.sCiudad = sCiudad;
        this.sImagen = sImagen;
        this.sNombre = sNombre;
        this.dLatitud = dLatitud;
        this.dLongitud = dLongitud;
        this.iIdProvincia = iIdProvincia;
        this.iIdDiscoteca = iIdDiscoteca;
    }

}