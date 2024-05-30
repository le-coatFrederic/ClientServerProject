package domain.entities.facture;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import domain.entities.article.Article;
import domain.values.EAN;

public class Facture {
    private int numero;
    private HashMap<EAN, Article> articles;
    private LocalDateTime dateDeCreation;
    
    public Facture(int numero) {
    	this.numero = numero;
    	dateDeCreation = LocalDateTime.now();
    	articles = new HashMap<EAN, Article>();
    }
    
    public int getNumero () {
    	return numero;
    }
    
    public HashMap<EAN, Article> getArticles () {
    	return articles;
    }
    
    public float totalMoney () {
    	float money = 0;
    	
    	for (Article article : articles.keySet()) {
    		money += article.getPrice() * articles.get(article);
    	}
    	
    	return money;
    }
    
    public int totalQuantity () {
    	int quantity = 0;
    	
    	for (Integer qte : articles.values()) {
    		quantity += qte;
    	}
    	
    	return quantity;
    }
    
    public LocalDateTime getDateCreationDateTime () {
    	return dateDeCreation;
    }
}