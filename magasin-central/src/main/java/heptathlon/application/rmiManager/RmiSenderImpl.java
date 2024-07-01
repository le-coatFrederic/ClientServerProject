package heptathlon.application.rmiManager;

import java.rmi.RemoteException;
import java.util.List;

import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;

public class RmiSenderImpl implements IRmiSender {

    @Override
    public List<Article> sendArticlesRmi(List<Article> articles) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Category> sendCategoriesRmi(List<Category> categories) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
