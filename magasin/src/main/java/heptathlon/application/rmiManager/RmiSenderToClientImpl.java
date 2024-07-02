package heptathlon.application.rmiManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;

public class RmiSenderToClientImpl extends UnicastRemoteObject implements IRmiSenderToClient {
    private IArticleDao articleDAO;
    private ICategoryDao categoryDAO;

    public RmiSenderToClientImpl(IArticleDao articleDAO, ICategoryDao categoryDAO) throws RemoteException {
        this.articleDAO = articleDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticles() throws RemoteException {
        List<Article> articles = articleDAO.getAllArticles();
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws RemoteException {
        List<Category> categories = categoryDAO.getAllCategory();
        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByEan(String ean) throws RemoteException {
        List<Article> articles = articleDAO.getAllArticlesByEAN(ean);
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByCategories(List<CategoryDTO> categoriesDTO) throws RemoteException {
        List<Category> categories = new ArrayList<Category>();
        categoriesDTO.forEach(categoryDTO -> {
            Category category = new Category(categoryDTO.getName());
            category.setId(categoryDTO.getId());
            categories.add(category);
        });

        List<Article> articles = articleDAO.getAllArticlesByCategories(categories);
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByIntitules(String intitule) throws RemoteException {
        List<Article> articles = articleDAO.getAllArticles();
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

}
