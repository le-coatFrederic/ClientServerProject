package domain.entities.article;

public class Article {
    private int id;
    private String ean;
    private String name;
    private String description;
    private float unitPrice;

    public Article(int idParam) {
        id = idParam;
        ean = null;
        name = "";
        description = "";
        unitPrice = 0;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getEan() {
    	return ean;
    }
    
    public String getName () {
    	return name;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public float getPrice() {
    	return unitPrice;
    }
    
    public void setName(final String nameParam) {
    	name = nameParam;
    }
    
    public void setDescription(final String descriptionParam) {
    	description = descriptionParam;
    }
    
    public void setPrice (final float priceParam) {
    	unitPrice = priceParam;
    }
}
