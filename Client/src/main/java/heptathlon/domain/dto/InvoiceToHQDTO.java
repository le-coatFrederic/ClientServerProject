package heptathlon.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import heptathlon.domain.entity.Invoice;

public class InvoiceToHQDTO implements Serializable {
    private long id;
    private double amount;
    private String fileLink;
    private LocalDateTime date;
    private Set<ArticleAndCategoryDTO> articles;
    private ShopDTO shop;

    public InvoiceToHQDTO() {}

    public InvoiceToHQDTO(Invoice invoice, ShopDTO shop) {
        this.id = invoice.getId();
        this.amount = invoice.getamount();
        this.fileLink = invoice.getFileLink();
        this.date = invoice.getDate();
        invoice.getArticles().forEach(article -> {
            this.articles.add(new ArticleAndCategoryDTO(article));
        });
        this.shop = shop;
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

    public ShopDTO getShop() {
        return shop;
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

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "InvoiceToHQDTO [id=" + id + ", amount=" + amount + ", fileLink=" + fileLink + ", date=" + date
                + ", articles=" + articles + ", shop=" + shop + "]";
    }

    public Invoice toInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(this.id);
        invoice.setamount(this.amount);
        invoice.setDate(this.date);
        invoice.setFileLink(this.fileLink);
        this.articles.forEach(article -> {
            invoice.addArticle(article.toArticle());
        });

        return invoice;
    }
    
}
