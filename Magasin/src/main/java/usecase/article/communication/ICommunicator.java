package usecase.article.communication;

import domain.entities.article.Article;

public interface ICommunicator {
    public void sendArticle(Article article);
    public void sendArticles();
}
