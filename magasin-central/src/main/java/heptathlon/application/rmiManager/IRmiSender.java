package heptathlon.application.rmiManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;

public interface IRmiSender extends Remote {
    public List<Article> sendArticlesRmi(List<Article> articles) throws RemoteException;
    public List<Category> sendCategoriesRmi(List<Category> categories) throws RemoteException;
}
