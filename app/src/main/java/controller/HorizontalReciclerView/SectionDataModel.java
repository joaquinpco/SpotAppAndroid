package controller.HorizontalReciclerView;

import java.util.ArrayList;

public class SectionDataModel
{
    private String _sHeaderTitle;
    private ArrayList<SingleItemModel> _aAllItemsInSection;

    /**
     * <h1>Empty Constructor</h1>
     */
    public SectionDataModel() {}

    /**
     *
     * @param sHeaderTitle Título de la sección(Provincia)
     * @param aAllItemsInSection Lista de discotecas por sección
     */
    public SectionDataModel(String sHeaderTitle,
                            ArrayList<SingleItemModel> aAllItemsInSection)
    {
        _sHeaderTitle = sHeaderTitle;
        _aAllItemsInSection = aAllItemsInSection;
    }

    /**
     *
     * @return Nombre de la provincia
     */
    public String getHeaderTitle() { return _sHeaderTitle; }

    /**
     *
     * @return Lista de discotecas por sección
     */
    public ArrayList<SingleItemModel> getAllItemsInSection() { return _aAllItemsInSection; }

    /**
     *
     * @param sHeaderTitle Título de la sección
     */
    public void setHeaderTitle(String sHeaderTitle) { _sHeaderTitle = sHeaderTitle; }

    /**
     *
     * @param aAllItemsInSection Discotecas por provincia
     */
    public void setAllItemsInSection(ArrayList<SingleItemModel> aAllItemsInSection)
    {
        _aAllItemsInSection = aAllItemsInSection;
    }


}
