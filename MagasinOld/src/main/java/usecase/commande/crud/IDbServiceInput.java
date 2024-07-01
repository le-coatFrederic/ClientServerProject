package usecase.commande.crud;

import domain.entities.commande.Commande;

public interface IDbServiceInput {
    public Article getCommande(Commande commande);
    public Article getCommandes();

    public Article getPrixTotal(Commande commande);
}