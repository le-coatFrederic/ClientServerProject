package application;

import java.util.ArrayList;

import domain.entities.article.Article;
import domain.usecase.article.ArticleCRUDUsecase;

public class Program {
	public static void main(String[] args) {
		try {
			ArrayList<Article> articles = new ArrayList<Article>();
			ArticleCRUDUsecase crudArticle = new ArticleCRUDUsecase(null, null);
			for (int i = 0; i < 300000; i++) {
				Article article = new Article(i, crudArticle);
				article.setDescription("Item de test");
				article.setEan(Integer.toString(article.getId()));
				articles.add(article);
			}

			for (Article article : articles) {
				article.setName("Test " + article.getId());
				System.out.println(article.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
