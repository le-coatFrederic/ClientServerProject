package domain.entities.entrepot;

import java.util.ArrayList;

import domain.entities.article.Article;

public class Entrepot {
	private int id;
	private ArrayList<Article> articles;
	private String intitule;
	
	public Entrepot(int id) {
		this.id = id;
		articles = new ArrayList<Article>();
		intitule = "";
	}
}
