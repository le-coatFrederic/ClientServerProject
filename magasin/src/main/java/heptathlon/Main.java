package heptathlon;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import heptathlon.application.communicationManager.CommunicationWithClientImpl;
import heptathlon.application.communicationManager.IRmiCommunicationWithShop;
import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.application.communicationManager.RmiSenderToClientImpl;
import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.application.dbManager.MySqlDbCommandHibernate;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.dto.InvoiceToHQDTO;
import heptathlon.domain.dto.ShopDTO;
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
            ShopDTO whoAmI = new ShopDTO(new Random().nextLong(), "Amiens");

            ICommunicationWithClient communicationWithClient = new CommunicationWithClientImpl(articleDao, categoryDao, invoiceDao);
            IRmiSenderToClient rmiSenderToClient = new RmiSenderToClientImpl(communicationWithClient);

            String ip = "localhost:30000";
            LocateRegistry.createRegistry(30000);
            Naming.rebind("//" + ip + "/ClientGet", rmiSenderToClient);

            String ipHQ = "localhost";
            IRmiCommunicationWithShop service = (IRmiCommunicationWithShop) Naming.lookup("//" + ipHQ + "/MagasinGet");
            
            do {
                service.getAllArticles().forEach(article -> {
                    articleDao.updateArticle(article.getId(), article.toArticle());
                });

                List<InvoiceToHQDTO> invoices = new ArrayList<>();
                invoiceDao.getAllInvoices().forEach(invoice -> {
                    invoices.add(new InvoiceToHQDTO(invoice, whoAmI));
                });
                TimeUnit.MINUTES.sleep(1);
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}