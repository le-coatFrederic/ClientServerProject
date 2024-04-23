package Models;

import java.sql.Date;

public class Facture {
    private int ID;

    private float montant;

    private String modeDePaiement;

    private Date dateDeFacturation;

    public Facture(int ID, float montant, String modeDePaiement, Date dateDeFacturation) {
        this.ID = ID;
        this.montant = montant;
        this.modeDePaiement = modeDePaiement;
        this.dateDeFacturation = dateDeFacturation;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getMontant() {
        return this.montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getModeDePaiement() {
        return this.modeDePaiement;
    }

    public void setModeDePaiement(String modeDePaiement) {
        this.modeDePaiement = modeDePaiement;
    }

    public Date getDateDeFacturation() {
        return this.dateDeFacturation;
    }

    public void setDateDeFacturation(Date dateDeFacturation) {
        this.dateDeFacturation = dateDeFacturation;
    }

}
