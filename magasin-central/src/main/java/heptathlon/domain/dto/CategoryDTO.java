package heptathlon.domain.dto;

import java.io.Serializable;

import heptathlon.domain.entity.Category;


public class CategoryDTO implements Serializable {
    private long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getIntitule();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDTO [id=" + id + ", name=" + name + "]";
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(this.getId());
        category.setIntitule(this.getName());

        return category;
    }
    
}
