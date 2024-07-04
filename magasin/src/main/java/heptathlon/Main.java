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
        try {
            IMySqlDbCommand dbCommand = new MySqlDbCommandHibernate();
            IArticleDao articleDao = new ArticleDaoImpl(dbCommand);
            ICategoryDao categoryDao = new CategoryDaoImpl(dbCommand);
            IInvoiceDao invoiceDao = new InvoiceDaoImpl(dbCommand);

            ICommunicationWithClient communicationWithClient = new CommunicationWithClientImpl(articleDao, categoryDao, invoiceDao);
            IRmiSenderToClient rmiSenderToClient = new RmiSenderToClientImpl(communicationWithClient);

            String ip = "localhost";
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//" + ip + "/ClientGet", rmiSenderToClient);

            String ipHQ = "localhost";
            ICommunicationWithClient service = (ICommunicationWithClient) Naming.lookup("//" + ipHQ + "/MagasinGet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}