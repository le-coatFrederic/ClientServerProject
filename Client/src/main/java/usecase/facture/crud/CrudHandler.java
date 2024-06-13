package usecase.facture.crud;

import domain.entities.facture.Facture;

public class CrudHandler {
    private IDbServiceInput dbServiceInput;
    private IDbServiceOutput dIDbServiceOutput;

    public CrudHandler(IDbServiceInput dbServiceInput, IDbServiceOutput dbServiceOutput) {
        if (dbServiceInput == null || dbServiceOutput == null) {
            throw new IllegalArgumentException();
        }

        this.dbServiceInput = dbServiceInput;
        this.dIDbServiceOutput = dbServiceOutput;
    }

    public void createFacture(Facture factureToSave) {
        if (factureToSave == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.createFacture(factureToSave);
    }

    public void printFacture(Facture factureToSave) {
        // code pour enregistrer le fichier
    }
}
