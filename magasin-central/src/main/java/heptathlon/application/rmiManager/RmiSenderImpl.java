package heptathlon.application.rmiManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;
import heptathlon.domain.usecase.communication.IMessengerSender;

public class RmiSenderImpl implements IRmiSender {

    @Override
    public List<Article> sendArticles(List<Article> articles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendArticles'");
    }

    @Override
    public List<Category> sendCategories(List<Category> categories) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendCategories'");
    }

    @Override
    public List<Article> sendArticlesRmi(List<Article> articles) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Category> sendCategoriesRmi(List<Category> categories) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
