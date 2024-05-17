package usecase.crudArticle;

import domain.entities.article.Article;
import domain.entities.article.IArticleHandler;

public class ArticleCRUDOperation implements IArticleHandler {
	private IArticleDBInput dbInput;
	private IArticleDBOutput dbOutput;
	
	public ArticleCRUDOperation(IArticleDBInput input, IArticleDBOutput output) {
		dbInput = input;
		dbOutput = output;
	}

	@Override
	public Article createArticle() {
		Article article = new Article(dbInput.getNextId(), this);
		
		dbOutput.createArticle(article);
		
		return article;
	}

	@Override
	public Article updateArticle(int oldArticleId, Article newArticle) {
		Article oldArticle = dbInput.getArticle(oldArticleId);
		if (oldArticle == null) {
			throw new Error("oldArticleId not pointing an existing article");
		}
		
		oldArticle.setCategorie(newArticle.getCategorie());
		oldArticle.setDescription(newArticle.getDescription());
		oldArticle.setEan(newArticle.getEan());
		oldArticle.setName(newArticle.getName());
		oldArticle.setPrice(newArticle.getPrice());
		
		dbOutput.updateArticle(oldArticle, newArticle);
		
		return oldArticle;
	}

	@Override
	public Article detailArticle(int id) {
		Article article = dbInput.getArticle(id);
		if (article == null) {
			throw new Error("no article with id " + id);
		}
		
		return article;
	}

	@Override
	public Article removeArticle(int id) {
		Article article = dbInput.getArticle(id);
		if (article == null) {
			throw new Error("no article with id " + id); 
		}
		
		dbOutput.removeArticle(article);
		
		return article;
	}
}
