package controller.HorizontalReciclerView;

public class SingleItemModel {

    private String _sName, _sUrl;

    /**
     * <h1>Empty Constructo</h1>
     */
    public SingleItemModel() {}

    /**
     *
     * @param sName Nombre de la discoteca
     * @param sUrl url del recurso
     */
    public SingleItemModel(String sName, String sUrl)
    {
        _sName = sName;
        _sUrl = sUrl;
    }

    /**
     *
     * @return Nombre de la discoteca
     */
    public String getName() { return _sName; }

    /**
     *
     * @return Url del recurso
     */
    public String getUrl() { return _sUrl; }

    /**
     *
     * @param sName Modifica el nombre de la discoteca
     */
    public void setName(String sName) { _sName = sName; }

    /**
     *
     * @param sUrl Cambia la url del recurso(Imagen)
     */
    public void setUrl(String sUrl) { _sUrl = sUrl; }

}
