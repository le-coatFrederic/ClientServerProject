package heptathlon.application.communicationManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;

public interface IRmiSenderToClient extends Remote {
    public List<ArticleAndCategoryDTO> getAllArticles() throws RemoteException;
    public List<ArticleAndCategoryDTO> getAllArticlesByEan(String ean) throws RemoteException;
    public List<ArticleAndCategoryDTO> getAllArticlesByCategories(List<CategoryDTO> categories) throws RemoteException;
    public List<ArticleAndCategoryDTO> getAllArticlesByIntitules(String intitule) throws RemoteException;
    public List<CategoryDTO> getAllCategories() throws RemoteException;
    public void sendInvoice(InvoiceDTO invoice) throws RemoteException;
}
