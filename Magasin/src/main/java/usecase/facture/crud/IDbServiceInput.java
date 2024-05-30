package usecase.facture.crud;

import domain.entities.facture.Facture;

public interface IDbServiceInput {
    public Facture getFacture(String facture);
}
