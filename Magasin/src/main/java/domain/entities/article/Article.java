package domain.entities.article;

import java.util.ArrayList;

import domain.values.Categorie;
import domain.values.EAN;

public class Article {
    private EAN ean;
    private String name;
    private String description;
    private float unitPrice;
    private ArrayList<Categorie> categories;

    public Article(final EAN id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        ean = id;
        name = "";
        description = "";
        unitPrice = 0;
        categories = new ArrayList<Categorie>();
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
    
    public ArrayList<Categorie> getCategorie() {
    	return categories;
    }

    public boolean categoriePresente(final Categorie categorieATester) {
        if (categories.contains(categorieATester)) {
            return true;
        }

        return false;
    }
    
    public void setName(final String nameParam) {
        if (nameParam == null) {
            throw new IllegalArgumentException();
        }

    	name = nameParam;
    }
    
    public void setDescription(final String descriptionParam) {
        if (descriptionParam == null) {
            throw new IllegalArgumentException();
        }

    	description = descriptionParam;
    }
    
    public void setPrice (final float priceParam) {
        unitPrice = priceParam;
    }
	
	public void addCategorie(final Categorie categorie) {
        if (categorie == null) {
            throw new IllegalArgumentException();
        }

        categories.add(categorie);
	}
	
	@Override
	public String toString() {
		return "ean : " + name + " - " + description + " -> " + unitPrice;
	}
}
