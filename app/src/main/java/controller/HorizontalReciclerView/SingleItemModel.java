package controller.HorizontalReciclerView;

public class SingleItemModel {

    private String name, url;

    public SingleItemModel() {}
    public SingleItemModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() { return name; }
    public String getUrl() { return url; }
    public void setName(String sName) { this.name = name; }
    public void setUrl(String sUrl) { this.url = url; }
}
