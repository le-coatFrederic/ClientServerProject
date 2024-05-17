package usecase.crudArticle;

import domain.entities.article.Article;

public interface IArticleDBOutput {
	void createArticle(Article newArticle);
	void updateArticle(Article oldArticle, Article newArticle);
	void removeArticle(Article article);
}
