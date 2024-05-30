package usecase.article.communication;

import java.util.List;

import domain.entities.article.Article;

public interface IServerCommunicator {
    public void sendArticles();
    public List getArticles();
}
