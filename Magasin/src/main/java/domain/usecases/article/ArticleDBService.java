package domain.usecases.article;

import domain.entities.article.ArticleAnnuaire;

public class ArticleDBService {
	private ArticleAnnuaire annuaire;
	private IArticleDBService dbService;
	
	public ArticleDBService(IArticleDBService dbService) {
		this.dbService = dbService;
	}
}
