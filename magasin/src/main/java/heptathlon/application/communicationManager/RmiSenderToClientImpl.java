package heptathlon.application.communicationManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;
import heptathlon.domain.usecase.communication.ICommunicationWithClient;

public class RmiSenderToClientImpl extends UnicastRemoteObject implements IRmiSenderToClient {
    private ICommunicationWithClient communication;

    public RmiSenderToClientImpl(ICommunicationWithClient communicator) throws RemoteException {
        super();
        this.communication = communicator;
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticles() throws RemoteException {
        return this.communication.getAllArticles();
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByEan(String ean) throws RemoteException {
        return this.communication.getAllArticlesByEan(ean);
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByCategories(List<CategoryDTO> categories) throws RemoteException {
        return this.getAllArticlesByCategories(categories);
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByIntitules(String intitule) throws RemoteException {
        return this.communication.getAllArticlesByIntitules(intitule);
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws RemoteException {
        return this.communication.getAllCategories();
    }

    @Override
    public void sendInvoice(InvoiceDTO invoice) {
        this.communication.sendInvoice(invoice);
    }

}
