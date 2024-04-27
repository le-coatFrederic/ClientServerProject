package domain.entities.article;

public class Article {
    private int id;
    private String ean;
    private String name;
    private String description;
    private float unitPrice;
    private IArticle presenter;

    public Article(int idParam, IArticle presenter) {
        id = idParam;
        ean = null;
        name = "";
        description = "";
        unitPrice = 0;
        this.presenter = presenter;
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

	public void setEan(String eanParam) {
		if (eanParam == null || eanParam.length() > 13) {
			throw new IllegalArgumentException();
		}
		
		ean = eanParam;
		
		while (ean.length() < 13) {
			ean.concat("0");
		}
	}
}
