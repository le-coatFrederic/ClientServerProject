package heptathlon.domain.dao;

import java.util.List;

import heptathlon.domain.entity.Category;

public interface ICategoryDao {
    public void addCategory(Category category);
    public void updateCategory(long oldCategoryId, Category newCategory);
    public void removeCategory(long categoryId);
    public List<Category> getAllCategory();
}
