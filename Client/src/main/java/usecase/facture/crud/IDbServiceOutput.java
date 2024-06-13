package usecase.facture.crud;

import domain.entities.facture.Facture;

public interface IDbServiceOutput {
    public void createFacture(Facture facture);
}
