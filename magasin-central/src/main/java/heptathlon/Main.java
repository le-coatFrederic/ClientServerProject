package heptathlon;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import heptathlon.application.communicationManager.CommunicationWithShopImpl;
import heptathlon.application.communicationManager.IRmiCommunicationWithShop;
import heptathlon.application.communicationManager.RmiSenderToShopImpl;
import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.application.dbManager.MySqlDbCommandHibernate;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.dto.ShopDTO;
import heptathlon.domain.usecase.communication.ICommunicationWithShop;
import heptathlon.domain.usecase.db.ArticleDaoImpl;
import heptathlon.domain.usecase.db.CategoryDaoImpl;
import heptathlon.domain.usecase.db.InvoiceDaoImpl;

public class Main {
    public static void main(String[] args) {
        IMySqlDbCommand dbCommand = new MySqlDbCommandHibernate();
        IArticleDao articleDao = new ArticleDaoImpl(dbCommand);
        ICategoryDao categoryDao = new CategoryDaoImpl(dbCommand);
        IInvoiceDao invoiceDao = new InvoiceDaoImpl(dbCommand);

        try {
            ICommunicationWithShop communicationWithShop = new CommunicationWithShopImpl(articleDao, categoryDao, invoiceDao);
            IRmiCommunicationWithShop rmiCommunicationWithShop = new RmiSenderToShopImpl(communicationWithShop);
            
            String ip = "localhost";
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//" + ip + "/MagasinGet", rmiCommunicationWithShop);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}