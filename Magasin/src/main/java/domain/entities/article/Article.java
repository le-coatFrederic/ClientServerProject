package domain.entities.article;

import domain.values.Categorie;
import domain.values.EAN;

public class Article {
	private int id;
    private EAN ean;
    private String name;
    private String description;
    private float unitPrice;
    private Categorie categorie;
    
    private IArticleCRUD presenter;

    public Article(final Integer id, IArticleCRUD presenter) {
    	this.id = id;
        ean = null;
        name = "";
        description = "";
        unitPrice = 0;
        categorie = null;
        this.presenter = presenter;
    }
    
    public int getId() {
    	return id;
    }
    
    public EAN getEan() {
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
    
    public Categorie getCategorie() {
    	return categorie;
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

	public void setEan(final EAN eanParam) {
		ean = eanParam;
	}
	
	public void setEan(final String eanParam) {
		ean.setEan(eanParam);
	}
	
	public void setCategorie(final Categorie categorie) {
		this.categorie = categorie;
	}
}