package Models;

/**
 * Magasin
 */
public class Article {

    private String reference;

    private String libelle;

    private float prix;

    public Article(String reference, String libelle, float prix) {
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return this.prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

}