package heptathlon;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import heptathlon.application.communicationManager.CommunicationWithClientImpl;
import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.application.communicationManager.RmiSenderToClientImpl;
import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.application.dbManager.MySqlDbCommandHibernate;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.usecase.communication.ICommunicationWithClient;
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
            ICommunicationWithClient communicationWithClient = new CommunicationWithClientImpl(articleDao, categoryDao, invoiceDao);
            IRmiSenderToClient rmiSenderToClient = new RmiSenderToClientImpl(communicationWithClient);

            String ip = "localhost:30000";
            LocateRegistry.createRegistry(30000);
            Naming.rebind("//" + ip + "/ClientGet", rmiSenderToClient);

            String ipHQ = "localhost";
            IRmiCommunicationWithShop service = (IRmiCommunicationWithShop) Naming.lookup("//" + ipHQ + "/MagasinGet");
            service.getAllArticles().forEach(article -> System.out.println(article));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}