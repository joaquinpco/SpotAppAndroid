package model.firebase;

/**
 * Created by joaquinpco on 12/2/18.
 */
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class FestivalesFb {

    public String sDescripcion,sEnlace,sFecha,sName;

    /**
     * Constructor predeterminado
     */
    FestivalesFb(){}

    /**
     * Constructor
     * @param sName Nombre del Festival
     * @param sEnlace Enlace de la imagen del Festival
     * @param sFecha Fecha de suceso del Festival
     * @param sDescripcion Descripcion del Festival
     */
    FestivalesFb(String sName,String sEnlace,String sFecha,String sDescripcion)
    {
        this.sDescripcion = sDescripcion;
        this.sEnlace = sEnlace;
        this.sName = sName;
        this.sFecha = sFecha;
    }

    public String getLink() { return sEnlace; }
    public String getName() { return sName; }
    public String getDescription() { return sDescripcion; }
    public String getFecha(){ return sFecha; }

}
