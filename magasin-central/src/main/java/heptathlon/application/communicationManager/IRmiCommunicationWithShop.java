package heptathlon.application.communicationManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceToHQDTO;

public interface IRmiCommunicationWithShop extends Remote {
    public List<ArticleAndCategoryDTO> getAllArticles() throws RemoteException;
    public List<CategoryDTO> getAllCategories() throws RemoteException;
    public void sendInvoices(List<InvoiceToHQDTO> invoices) throws RemoteException;
}
