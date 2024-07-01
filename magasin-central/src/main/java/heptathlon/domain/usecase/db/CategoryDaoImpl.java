package heptathlon.domain.usecase.db;

import java.util.List;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.entity.Category;

public class CategoryDaoImpl implements ICategoryDao {
    private IMySqlDbCommand dbCommand;

    public CategoryDaoImpl(final IMySqlDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public void addCategory(Category category) {
        this.dbCommand.executeTransaction(session -> session.save(category));
    }

    @Override
    public void updateCategory(long oldCategoryId, Category newCategory) {
        this.dbCommand.executeTransaction(session -> {
            Category category = null;
            session.get(Category.class, oldCategoryId);
            if (category != null) {
                category.update(newCategory);
                session.update(category);
            }
        });
    }

    @Override
    public void removeCategory(long categoryId) {
        this.dbCommand.executeTransaction(session -> {
            Category category = session.get(Category.class, categoryId);
            if (category != null) {
                session.delete(category);
            }
        });
    }

    @Override
    public List<Category> getAllCategory() {
        return this.dbCommand.executeQuery(session -> session.createQuery("from Category", Category.class).list());
    }
}
