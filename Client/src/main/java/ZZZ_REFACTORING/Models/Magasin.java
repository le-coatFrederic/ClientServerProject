package Models;

/**
 * Magasin
 */
public class Magasin {

    private int ID;

    private String libelle;

    public Magasin(int ID, String libelle) {
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