package domain.entities.entrepot;

import java.util.ArrayList;
import javax.management.InstanceNotFoundException;
import domain.entities.article.Article;
import domain.entities.article.IArticle;

public class Entrepot implements IEntrepot {
	private int id;
	private ArrayList<IArticle> articles;
	private String intitule;
	
	public Entrepot(int id) {
		this.id = id;
		articles = new ArrayList<IArticle>();
		intitule = "";
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public ArrayList<IArticle> getArticles() {
		return articles;
	}

	@Override
	public IArticle getArticle(int index) {
		return articles.get(index);
	}

	@Override
	public IArticle getArticle(IArticle article) {
		return articles.get(articles.indexOf(article));
	}

	@Override
	public void addArticle(IArticle article) {
		if (article == null) {
			throw new NullPointerException();
		} else {
			try {
				articles.add(article);				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removeArticle(int index) {
		if (index <= articles.size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		articles.remove(index);		
	}

	@Override
	public void removeArticle(IArticle article) {
		if (article == null) {
			throw new NullPointerException();
		}
		
		int index = articles.indexOf(article);
		if (index == -1) {
			throw new Error("This article is not present in the stock");
		}

		this.removeArticle(index);
	}

	@Override
	public String getIntitule() {
		return intitule;
	}

	@Override
	public void setIntitule(String intitule) {
		if (intitule != null && intitule != "" && intitule.length() < 4) {
			throw new IllegalArgumentException();
		}
		
		this.intitule = intitule;
	}
}
