package heptathlon.domain.usecase.db;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.entity.Invoice;

public class InvoiceDaoImpl implements IInvoiceDao {
    private IMySqlDbCommand dbCommand;

    public InvoiceDaoImpl(final IMySqlDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public void addInvoice(Invoice newInvoice) {
        this.dbCommand.executeTransaction(session -> session.save(newInvoice));
    }

    @Override
    public void updateInvoice(long oldInvoiceId, Invoice newInvoice) {
        this.dbCommand.executeTransaction(session -> {
            Invoice invoice = session.get(Invoice.class, oldInvoiceId);
            if (invoice != null) {
                invoice.update(newInvoice);
                session.update(invoice);
            }
        });
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return this.dbCommand.executeQuery(session -> {
            List<Invoice> invoices = session.createQuery("from Invoice", Invoice.class).list();
            for (Invoice invoice: invoices) {
                Hibernate.initialize(invoice.getArticles());
            }
            return invoices;
        });
    }

    @Override
    public List<Invoice> getAllInvoicesByDate(LocalDateTime date) {
        return this.dbCommand.executeQuery(session -> {
            List<Invoice> invoices = session.createQuery("from Invoice where date = :date", Invoice.class)
                .setParameter("date", date)
                .list();
            for (Invoice invoice: invoices) {
                Hibernate.initialize(invoice.getArticles());
            }
            return invoices;
        }); 
    }

    @Override
    public List<Invoice> getAllInvoicesBeforeDate(LocalDateTime date) {
        return this.dbCommand.executeQuery(session -> {
            List<Invoice> invoices = session.createQuery("from Invoice where date < :date", Invoice.class)
                .setParameter("date", date)
                .list();
            for (Invoice invoice: invoices) {
                Hibernate.initialize(invoice.getArticles());
            }
            return invoices;
        }); 
    }

    @Override
    public List<Invoice> getAllInvoicesAfterDate(LocalDateTime date) {
        return this.dbCommand.executeQuery(session -> {
            List<Invoice> invoices = session.createQuery("from Invoice where date > :date", Invoice.class)
                .setParameter("date", date)
                .list();
            for (Invoice invoice: invoices) {
                Hibernate.initialize(invoice.getArticles());
            }
            return invoices;
        }); 
    }

    @Override
    public List<Invoice> getAllInvoicesBetweenDate(LocalDateTime date1, LocalDateTime date2) {
        return this.dbCommand.executeQuery(session -> {
            List<Invoice> invoices = session.createQuery("from Invoice where date BETWEEN :date1 AND :date2", Invoice.class)
                .setParameter("date1", date1)
                .setParameter("date2", date2)
                .list();
            for (Invoice invoice: invoices) {
                Hibernate.initialize(invoice.getArticles());
            }
            return invoices;
        }); 
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return this.dbCommand.executeQuery(session -> {
            Invoice invoice = session.get(Invoice.class, id);
            Hibernate.initialize(invoice.getArticles());
            return invoice;
        });
    }
}
