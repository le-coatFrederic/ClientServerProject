package domain.entity;

import java.util.ArrayList;
import java.util.Date;

public class Facture {
    private String id;
    private double montant;
    private Date dateFacturation;
    private String lienFacture;
    private final ArrayList<Article> articles;

    public Facture (String id, double montant, String lienFacture) {
        this.id = id;
        this.montant = montant;
        this.dateFacturation = new Date();
        this.lienFacture = lienFacture;
        this.articles = new ArrayList<>();
    }

    public void ajouterArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException();
        }

        this.articles.add(article);
    }

    public void supprimerArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException();
        }

        this.articles.remove(article);
    }

    public String getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public String getLienFacture() {
        return lienFacture;
    }

    public void setMontant(final double montant) {
        if (montant < 0) {
            throw new IllegalArgumentException();
        }

        this.montant = montant;
    }

    public void setDateFacturation(final Date dateFacturation) {
        if (dateFacturation == null) {
            throw new IllegalArgumentException();
        }

        this.dateFacturation = dateFacturation;
    }

    public void setLienFacture(final String lienFacture) {
        if (lienFacture.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.lienFacture = lienFacture;
    }
    
}
