package usecase.article.crud;

import java.util.ArrayList;

import domain.entities.article.Article;
import domain.entities.values.EAN;

public class CrudHandler {
    private IDbServiceInput dbServiceInput;
    private IDbServiceOutput dIDbServiceOutput;

    public CrudHandler(IDbServiceInput dbServiceInput, IDbServiceOutput dbServiceOutput) {
        if (dbServiceInput == null || dbServiceOutput == null) {
            throw new IllegalArgumentException();
        }

        this.dbServiceInput = dbServiceInput;
        this.dIDbServiceOutput = dbServiceOutput;
    }

    public void saveArticle(Article articleToSave) {
        if (articleToSave == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.addArticle(articleToSave);
    }

    public Article searchArticle(EAN ean) {
        Article article = dbServiceInput.getArticle(ean);
        if (article == null) {
            throw new NullPointerException();
        }

        return article;
    }

    public Article searchArticle(String ean) {
        Article article = dbServiceInput.getArticle(ean);
        if (article == null) {
            throw new NullPointerException();
        }

        return article;
    }

    public ArrayList<Article> getArticles() {
        ArrayList<Article> articles = dbServiceInput.getArticles();
        if (articles == null) {
            throw new IllegalArgumentException();
        }
        
        return articles;
    }

    public int countArticles() {
        return dbServiceInput.getHowManyArticle();
    }

    public int countDifferentArticles() {
        return dbServiceInput.getHowManyDifferentArticle();
    }
}
