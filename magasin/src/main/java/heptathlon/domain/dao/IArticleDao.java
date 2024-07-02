package heptathlon.domain.dao;

import java.util.List;

import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;

public interface IArticleDao {
    public void addArticle(Article newArticle);
    public void updateArticle(long oldArticleId, Article newArticle);
    public void removeArticle(long articleId);
    public List<Article> getAllArticles();
    public List<Article> getAllArticlesByEAN(String ean);
    public List<Article> getAllArticlesByIntitule(String intitule);
    public List<Article> getAllArticlesByCategories(List<Category> categories);
    public Article getArticleById(long id);
}
