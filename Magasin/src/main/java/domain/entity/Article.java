package domain.entity;

import java.util.ArrayList;

import domain.value.EAN;
import domain.value.FamilleArticle;

public class Article {
    private final EAN reference;
    private String libelle;
    private double prix;
    private int quantite;
    private final ArrayList<FamilleArticle> familleArticle;

    public Article(EAN reference, String libelle) {
        this.reference = reference;
        this.libelle = libelle;
        this.prix = 0;
        this.quantite = 0;
        this.familleArticle = new ArrayList<>();
    }

    public void ajouterFamille(FamilleArticle famille) {
        if (famille == null) {
            throw new IllegalArgumentException();
        }

        this.familleArticle.add(famille);
    }

    public void retirerFamille(FamilleArticle famille) {
        if (famille == null) {
            throw new IllegalArgumentException();
        }

        this.familleArticle.remove(famille);
    }

    public void setLibelle(String libelle) {
        if (libelle == null || libelle.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.libelle = libelle;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException();
        }

        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException();
        }

        this.quantite = quantite;
    }

    public EAN getReference() {
        return reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public ArrayList<FamilleArticle> getFamillesArticle() {
        return familleArticle;
    }
}
