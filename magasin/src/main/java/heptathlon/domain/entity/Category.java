package heptathlon.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    private long idCategory;
    private String intitule;

    @ManyToMany(mappedBy = "categories")
    private Set<Article> articles = new HashSet<>();

    public Category() {}

    public Category(String intitule) {
        this.intitule = intitule;
    }

    public long getId() {
        return idCategory;
    }

    public String getIntitule() {
        return intitule;
    }

    public Set<Article> getArticles() {
        return this.articles;
    }

    public void setId(long id) {
        this.idCategory = id;
    }

    public void setIntitule(String intitule) {
        if (intitule.isBlank()) {
            throw new IllegalArgumentException();
        }
        
        this.intitule = intitule;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    public void update(Category newCategory) {
        if (newCategory == null) {
            throw new IllegalArgumentException();
        }

        this.setArticles(newCategory.getArticles());
        this.setIntitule(newCategory.getIntitule());
    }
}
