package usecase.article.dto;

import java.util.ArrayList;

import domain.entities.article.Article;

public class dtoListArticle {
    private ArrayList<Article> articles;

    public dtoListArticle() {
        articles = new ArrayList<>();
    }

    public void addArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException();
        }

        articles.add(article);
    }

    public void removeArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException();
        }

        if (articles.contains(article)) {
            articles.remove(article);
        }
    }

    public ArrayList<Article> getArticleList() {
        return articles;
    }
}
