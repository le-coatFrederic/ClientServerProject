package usecase.article.crud;

import java.util.ArrayList;

import domain.entities.article.Article;
import domain.entities.values.EAN;

public interface IDbServiceInput {
    public Article getArticle(EAN ean);
    public Article getArticle(String ean);
    public ArrayList<Article> getArticles();
    public int getHowManyArticle();
    public int getHowManyDifferentArticle();
}
