package src.main.java.usecase.commande.crud;

import src.main.java.domain.entities.commande.Commande;

public interface IDbServiceOutput {
    public void createCommande(Commande commande);

    public void annulerCommande(Commande commande);

    public void validerCommande(Commande commande);

    public void addArticleCommande(Commande commande, Article article);

    public void removeArticleCommande(Commande commande, Article article);
}
