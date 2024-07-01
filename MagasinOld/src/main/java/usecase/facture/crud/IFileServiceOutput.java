package usecase.facture.crud;

import domain.entities.facture.Facture;

public interface IFileServiceOutput {
    public void printFacture(Facture facture);
}
