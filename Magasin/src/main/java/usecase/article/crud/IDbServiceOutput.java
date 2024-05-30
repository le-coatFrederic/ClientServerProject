package usecase.article.crud;

import domain.entities.article.Article;

public interface IDbServiceOutput {
    public void addArticle(Article article);
    public void updateArticle(Article oldArticle, Article newArticle);
    public void removeArticle(Article article);
}
