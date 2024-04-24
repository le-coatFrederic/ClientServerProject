package domain.entities.article;

import java.util.ArrayList;

public class ArticleAnnuaire {
	private static volatile ArticleAnnuaire instanceAnnuaire;
	private ArrayList<Article> articles;
	
	
	public ArticleAnnuaire() {
		articles = new ArrayList<Article>();
	}
	
	public static ArticleAnnuaire getInstanceAnnuaire() {
		ArticleAnnuaire annuaire = instanceAnnuaire;
		if (annuaire != null) {
			return annuaire;
		}
		
		synchronized (ArticleAnnuaire.class) {
			if (instanceAnnuaire == null) {
				instanceAnnuaire = new ArticleAnnuaire();
			}
			return instanceAnnuaire;
		}
	}
	
	public synchronized void addArticle(Article articleParam) {
		if (articleParam == null) {
			throw new NullPointerException();
		} else {
			articles.add(articleParam);
		}
	}
	
	public synchronized void removeArticle(Article articleParam) {
		if (articleParam == null) {
			throw new NullPointerException();
		} else {
			articles.remove(articles.indexOf(articleParam));
		}
	}
}
