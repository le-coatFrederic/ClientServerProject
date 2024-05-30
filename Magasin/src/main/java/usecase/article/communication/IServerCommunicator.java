package usecase.article.communication;

import java.util.ArrayList;

import domain.entities.article.Article;

public interface IServerCommunicator {
    public void sendArticles(ArrayList<Article> articles);
    public ArrayList<Article> getArticles();
}
