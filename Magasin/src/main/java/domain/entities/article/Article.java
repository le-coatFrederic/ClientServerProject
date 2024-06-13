package domain.entities.article;

import java.util.ArrayList;

import domain.entities.values.Categorie;
import domain.entities.values.EAN;

public class Article {
    private EAN ean;
    private String name;
    private String description;
    private int quantity;
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
        quantity = 0;
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

    public int getQuantity() {
        return quantity;
    }
    
    public ArrayList<Categorie> getCategorie() {
    	return categories;
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
        if (priceParam < 0) {
            throw new IllegalArgumentException();
        }
        unitPrice = priceParam;
    }

    public void setQuantity(final int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }

        this.quantity = quantity;
    }
	
	public void addCategorie(final Categorie categorie) {
        if (categorie == null) {
            throw new IllegalArgumentException();
        }

        categories.add(categorie);
	}

    public boolean categoriePresente(final Categorie categorieATester) {
        if (categories.contains(categorieATester)) {
            return true;
        }

        return false;
    }
	
	@Override
	public String toString() {
		return "ean : " + name + " - " + description + " -> " + unitPrice;
	}
}
