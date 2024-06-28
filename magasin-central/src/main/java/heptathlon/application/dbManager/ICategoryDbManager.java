package heptathlon.application.dbManager;

import java.util.List;

import heptathlon.domain.entity.Category;

public interface ICategoryDbManager {
    public void addCategory(Category category);
    public void updateCategory(long oldCategoryId, Category newCategory);
    public void removeCategory(long categoryId);
    public Category detailCategory(long categoryId);
    public List<Category> getAllCategory();
}
