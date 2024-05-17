package usecase.crudArticle;

import domain.entities.article.Article;
import domain.values.EAN;

public interface IArticleDBInput {
	Article getArticle(int id);
	Article getArticle(EAN ean);
	int getNextId();
}
