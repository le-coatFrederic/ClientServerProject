package heptathlon.application.communicationManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;
import heptathlon.domain.usecase.communication.ICommunicationWithShop;

public class RmiSenderToShopImpl extends UnicastRemoteObject implements IRmiCommunicationWithShop {
    private ICommunicationWithShop communicator;

    public RmiSenderToShopImpl(ICommunicationWithShop communicator) throws RemoteException {
        super();
        this.communicator = communicator;
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticles() throws RemoteException {
        return this.communicator.getAllArticles();
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws RemoteException {
        return this.communicator.getAllCategories();
    }

    @Override
    public void sendInvoices(List<InvoiceDTO> invoices) throws RemoteException {
        this.communicator.sendInvoices(invoices);
    }
    
}
