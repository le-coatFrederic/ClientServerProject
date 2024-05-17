package application.dbService;

import java.util.ArrayList;

import domain.entities.article.Article;
import domain.values.EAN;
import usecase.crudArticle.IArticleDBInput;
import usecase.crudArticle.IArticleDBOutput;

public class dbHandler implements IArticleDBOutput, IArticleDBInput{
	ArrayList<Article> articles = new ArrayList<Article>();

	@Override
	public void createArticle(Article newArticle) {
		System.out.println("creating " + newArticle);
		articles.add(newArticle);
	}

	@Override
	public void updateArticle(Article oldArticle, Article newArticle) {
		System.out.println("changed " + oldArticle + " by " + newArticle);
		
	}

	@Override
	public void removeArticle(Article article) {
		System.out.println("removing " + article);
	    articles.remove(article.getId());
	}

	@Override
	public Article getArticle(int id) {
		return articles.get(id);
	}

	@Override
	public Article getArticle(EAN ean) {
		for (Article article: articles) {
			if (article.getEan() == ean) {
				return article;
			}
		}
		
		throw new IllegalArgumentException();
	}

	@Override
	public int getNextId() {
		return articles.size();
	}

}
