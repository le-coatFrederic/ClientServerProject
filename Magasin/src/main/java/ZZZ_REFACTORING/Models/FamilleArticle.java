package Models;

/**
 * FamilleArticle
 */
public class FamilleArticle {

    private int ID;

    private String libelle;

    public FamilleArticle(int ID, String libelle) {
        this.ID = ID;
        this.libelle = libelle;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}