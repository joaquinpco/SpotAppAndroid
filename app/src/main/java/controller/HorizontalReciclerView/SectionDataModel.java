package controller.HorizontalReciclerView;

import java.util.ArrayList;

public class SectionDataModel
{
    private String headerTitle;
    private ArrayList<SingleItemModel> itemsInSection;
    public SectionDataModel() {}
    public SectionDataModel(
            String headerTitle,
            ArrayList<SingleItemModel> itemsInSection
    ) {
        this.headerTitle = headerTitle;
        this.itemsInSection = itemsInSection;
    }

    public String getHeaderTitle() { return this.headerTitle; }
    public ArrayList<SingleItemModel> getAllItemsInSection() { return this.itemsInSection; }
    public void setHeaderTitle(String headerTitle) { this.headerTitle = headerTitle; }
    public void setAllItemsInSection(ArrayList<SingleItemModel> aAllItemsInSection) {
        this.itemsInSection = aAllItemsInSection;
    }
}
