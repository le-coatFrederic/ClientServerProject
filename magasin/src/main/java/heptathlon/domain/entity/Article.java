package heptathlon.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue
    private long idArticle;

    private String ean;
    private String intitule;
    private double price;

    @ManyToMany
    @JoinTable(
        name = "article_category",
        joinColumns = @JoinColumn(name = "idCategory"),
        inverseJoinColumns = @JoinColumn(name = "idArticle")
    )
    private Set<Category> categories = new HashSet<>();

    public Article() {}

    public Article(String ean, String intitule) {
        this.ean = ean;
        this.intitule = intitule;
    }

    public long getId() {
        return this.idArticle;
    }

    public String getEan() {
        return this.ean;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public double getPrice() {
        return this.price;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setId(long id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }

        this.idArticle = id;
    }

    public void setEan(String ean) {
        if (ean.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.ean = ean;
    }

    public void setIntitule(String intitule) {
        if (intitule.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.intitule = intitule;
    }

    public void setPrice(Double price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }

        this.price = price;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
        for (Category category : this.categories) {
            category.addArticle(this);
        }
    }

    public void addCategory(Category categoryToAdd) {
        this.categories.add(categoryToAdd);
        categoryToAdd.addArticle(this);
    }

    public void removeCategory(Category categoryToRemove) {
        this.categories.remove(categoryToRemove);
        categoryToRemove.removeArticle(this);
    }

    public void update(Article newArticle) {
        if (newArticle == null) {
            throw new IllegalArgumentException();
        }

        this.setEan(newArticle.getEan());
        this.setIntitule(newArticle.getIntitule());
        this.setPrice(newArticle.getPrice());
        this.setCategories(newArticle.getCategories());
        for (Category category : this.categories) {
            category.removeArticle(newArticle);
        }
    }
}
