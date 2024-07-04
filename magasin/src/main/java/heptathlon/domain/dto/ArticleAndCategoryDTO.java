package heptathlon.domain.dto;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import heptathlon.domain.entity.Article;

public class ArticleAndCategoryDTO implements Serializable {
    private long id;
    private String ean;
    private String intitule;
    private double price;
    private Set<CategoryDTO> categories;

    public ArticleAndCategoryDTO() {}

    public ArticleAndCategoryDTO(Article article) {
        this.id = article.getId();
        this.ean = article.getEan();
        this.intitule = article.getIntitule();
        this.categories = article.getCategories().stream().map(CategoryDTO::new).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getEan() {
        return ean;
    }

    public String getIntitule() {
        return intitule;
    }

    public double getPrice() {
        return this.price;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ArticleAndCategoryDTO [id=" + id + ", ean=" + ean + ", intitule=" + intitule + ", price=" + price
                + ", categories=" + categories + "]";
    }
    
}
