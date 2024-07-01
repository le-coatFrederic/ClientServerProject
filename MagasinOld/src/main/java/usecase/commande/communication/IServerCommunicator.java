package usecase.commande.communication;

import domain.entities.commande.Commande;

public interface IServerCommunicator {
    public void sendCommandes();

    public List getCommandes();
}
