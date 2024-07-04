package heptathlon.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import heptathlon.domain.entity.Invoice;

public class InvoiceDTO implements Serializable {
    private long id;
    private double amount;
    private String fileLink;
    private LocalDateTime date;

    public InvoiceDTO() {}

    public InvoiceDTO(Invoice invoice) {
        this.id = invoice.getId();
        this.amount = invoice.getamount();
        this.fileLink = invoice.getFileLink();
        this.date = invoice.getDate();
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getFileLink() {
        return fileLink;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Invoice toInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(this.id);
        invoice.setDate(this.date);
        invoice.setamount(this.amount);
        invoice.setFileLink(this.fileLink);
        return invoice;
    }

    @Override
    public String toString() {
        return "InvoiceDTO [id=" + id + ", amount=" + amount + ", fileLink=" + fileLink + ", date=" + date + "]";
    }
}
