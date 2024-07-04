package heptathlon.domain.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Invoice {
    private long id;
    private double amount;
    private String fileLink;
    private LocalDateTime date;
    private Set<Article> articles = new HashSet<>();

    public Invoice() {
        this.fileLink = "";
        this.amount = 0;
        this.date = LocalDateTime.now();
    }

    public Invoice(String fileLink, double amount) {
        this.fileLink = fileLink;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public double getamount() {
        return amount;
    }

    public String getFileLink() {
        return fileLink;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setamount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = amount;
    }

    public void setFileLink(String fileLink) {
        if (fileLink.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.fileLink = fileLink;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article articleToAdd) {
        this.articles.add(articleToAdd);
        this.amount += articleToAdd.getPrice();
    }

    public void update(Invoice newInvoice) {
        if (newInvoice == null) {
            throw new IllegalArgumentException();
        }

        this.amount = newInvoice.getamount();
        this.fileLink = newInvoice.getFileLink();
        this.setArticles(newInvoice.getArticles());
        this.date = newInvoice.getDate();
    }
}
