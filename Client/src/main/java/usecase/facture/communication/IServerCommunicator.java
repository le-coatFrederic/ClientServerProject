package usecase.facture.communication;

import java.util.List;

import domain.entities.facture.Facture;

public interface IServerCommunicator {
    public void sendFactures();

    public List getFactures();
}
