package heptathlon.domain.dao;

import java.util.List;

import heptathlon.domain.entity.Article;

public interface IArticleDao {
    public void addArticle(Article newArticle);
    public void updateArticle(long oldArticleId, Article newArticle);
    public void removeArticle(long articleId);
    public List<Article> getAllArticles();
    public List<Article> getAllArticlesByEAN(String ean);
    public List<Article> getAllArticlesByIntitule(String intitule);
    public Article getArticleById(long id);
}
