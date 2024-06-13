package usecase.article.crud;

import domain.entities.article.Article;
import domain.values.EAN;

public interface IDbServiceInput {
    public Article getArticle(EAN ean);
    public Article getArticle(String ean);
    public int getHowManyArticle();
    public int getHowManyDifferentArticle();
}
