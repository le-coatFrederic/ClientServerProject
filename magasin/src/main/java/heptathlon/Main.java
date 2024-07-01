package heptathlon;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.application.dbManager.MySqlDbCommandHibernate;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Invoice;
import heptathlon.domain.usecase.db.ArticleDaoImpl;
import heptathlon.domain.usecase.db.CategoryDaoImpl;
import heptathlon.domain.usecase.db.InvoiceDaoImpl;

public class Main {
    public static void main(String[] args) {
        IMySqlDbCommand mySqlDbCommand = new MySqlDbCommandHibernate();
        IArticleDao articleDb = new ArticleDaoImpl(mySqlDbCommand);
        ICategoryDao categoryDb = new CategoryDaoImpl(mySqlDbCommand);
        IInvoiceDao invoiceDb = new InvoiceDaoImpl(mySqlDbCommand);

        Article articleUpdate = articleDb.getArticleById(1);

        Invoice invoiceUpdate = new Invoice();
        invoiceUpdate.setamount(122.98);
        invoiceUpdate.setFileLink("INVOICE//test.invoice.csv");
        invoiceUpdate.addArticle(articleUpdate);
        invoiceDb.updateInvoice(6, invoiceUpdate);
    }
}