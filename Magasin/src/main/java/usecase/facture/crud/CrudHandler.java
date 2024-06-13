package usecase.facture.crud;

import domain.entities.facture.Facture;

public class CrudHandler {
    private IDbServiceInput dbServiceInput;
    private IDbServiceOutput dIDbServiceOutput;
    private IFileServiceOutput IFileServiceOutput;

    public CrudHandler(IDbServiceInput dbServiceInput, IDbServiceOutput dbServiceOutput,
            IFileServiceOutput IFileServiceOutput) {
        if (dbServiceInput == null || dbServiceOutput == null) {
            throw new IllegalArgumentException();
        }

        this.dbServiceInput = dbServiceInput;
        this.dIDbServiceOutput = dbServiceOutput;
        this.IFileServiceOutput = IFileServiceOutput;
    }

    public void getFacture(Facture factureToSave) {
        if (factureToSave == null) {
            throw new IllegalArgumentException();
        }

        IDbServiceInput.getFacture(factureToSave);
    }

    public void getFactures() {
        IDbServiceInput.getFactures();
    }

    public void createFacture(Facture factureToSave) {
        if (factureToSave == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.createFacture(factureToSave);
    }

    public void printFacture(Facture factureToSave) {
        if (factureToSave == null) {
            throw new IllegalArgumentException();
        }

        IFileServiceOutput.printFacture(factureToSave);
    }

    public void sendFactureMagasin(Facture factureToSave) {
        if (factureToSave == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.sendFactureMagasin(factureToSave);
    }
}
