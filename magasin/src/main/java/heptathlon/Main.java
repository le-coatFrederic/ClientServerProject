package heptathlon;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.application.dbManager.MySqlDbCommandHibernate;
import heptathlon.application.rmiManager.IRmiSenderToClient;
import heptathlon.application.rmiManager.RmiSenderToClientImpl;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.usecase.db.ArticleDaoImpl;
import heptathlon.domain.usecase.db.CategoryDaoImpl;

public class Main {
    public static void main(String[] args) {
        try {
            IMySqlDbCommand dbCommand = new MySqlDbCommandHibernate();
            IArticleDao articleDao = new ArticleDaoImpl(dbCommand);
            ICategoryDao categoryDao = new CategoryDaoImpl(dbCommand);

            IRmiSenderToClient senderToClient = new RmiSenderToClientImpl(articleDao, categoryDao);

            String ip = "93.8.39.46";
            System.setProperty("java.rmi.server.hostname", ip);
            LocateRegistry.createRegistry(9010);
            Naming.rebind("//" + ip + "/ClientGet", senderToClient);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}