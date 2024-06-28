package heptathlon.application.dbManager;

import java.time.LocalDateTime;
import java.util.List;

import heptathlon.domain.entity.Invoice;
import heptathlon.domain.entity.Shop;

public interface IInvoiceDbManager {
    public void addInvoice(Invoice newInvoice);
    public void updateInvoice(long oldInvoiceId, Invoice newInvoice);
    public List<Invoice> getAllInvoices();
    public List<Invoice> getAllInvoicesByShop(Shop shop);
    public List<Invoice> getAllInvoicesByDate(LocalDateTime date);
    public List<Invoice> getAllInvoicesBeforeDate(LocalDateTime date);
    public List<Invoice> getAllInvoicesAfterDate(LocalDateTime date);
    public List<Invoice> getAllInvoicesBetweenDate(LocalDateTime date1, LocalDateTime date2);
    public Invoice getInvoiceById(long id);
}
