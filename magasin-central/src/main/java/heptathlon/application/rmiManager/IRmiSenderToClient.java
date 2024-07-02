package heptathlon.application.rmiManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;

public interface IRmiSenderToClient extends Remote {
    public List<ArticleAndCategoryDTO> getAllArticles() throws RemoteException;
    public List<ArticleAndCategoryDTO> getAllArticlesByEan(String ean) throws RemoteException;
    public List<ArticleAndCategoryDTO> getAllArticlesByCategories(List<CategoryDTO> categories) throws RemoteException;
    public List<ArticleAndCategoryDTO> getAllArticlesByIntitules(String intitule) throws RemoteException;
    public List<CategoryDTO> getAllCategories() throws RemoteException;
}
