package heptathlon.domain.usecase.db;

import java.util.List;

import org.hibernate.Hibernate;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;

public class ArticleDaoImpl implements IArticleDao {
    private IMySqlDbCommand dbCommand;

    public ArticleDaoImpl(final IMySqlDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public void addArticle(Article newArticle) {
        this.dbCommand.executeTransaction(session -> session.save(newArticle));
    }

    @Override
    public void updateArticle(long oldArticleId, Article newArticle) {
        this.dbCommand.executeTransaction(session -> {
            Article article = session.get(Article.class, oldArticleId);
            if (article != null) {
                article.update(newArticle);
                session.update(article);
            }
        });
    }

    @Override
    public void removeArticle(long articleId) {
        this.dbCommand.executeTransaction(session -> {
            Article article = session.get(Article.class, articleId);
            if (article != null) {

                session.delete(article);
            }
        });
    }

    @Override
    public List<Article> getAllArticles() {
        return this.dbCommand.executeQuery(session -> {
            List<Article> articles = session.createQuery("from Article", Article.class).list();
            for (Article article: articles) {
                Hibernate.initialize(article.getCategories());
            }
            return articles;
        });
    }

    @Override
    public List<Article> getAllArticlesByEAN(String ean) {
        return this.dbCommand.executeQuery(session -> {
            List<Article> articles = session.createQuery("from Article where ean like :ean", Article.class)
                .setParameter("ean", ean)
                .list();
            for(Article article: articles) {
                Hibernate.initialize(article.getCategories());
            }
            return articles;
        });
    }

    @Override
    public List<Article> getAllArticlesByIntitule(String intitule) {
        return this.dbCommand.executeQuery(session -> {
            List<Article> articles = session.createQuery("from Article where intitule like :intitule", Article.class)
                .setParameter("intitule", intitule)
                .list();
            for(Article article: articles) {
                Hibernate.initialize(article.getCategories());
            }
            return articles;
        });
    }

    public Article getArticleById(long id) {
        return this.dbCommand.executeQuery(session -> {
            Article article = session.get(Article.class, id);
            Hibernate.initialize(article.getCategories());
            return article;
        });   
    }

    @Override
    public List<Article> getAllArticlesByCategories(List<Category> categories) {
        return this.dbCommand.executeQuery(session -> {
            return session.createQuery("select a from Article a join a.categories c where c in :categories", Article.class)
                .setParameter("categories", categories)
                .list();
        });
    }
}
