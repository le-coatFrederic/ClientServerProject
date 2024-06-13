package usecase.commande.crud;

import domain.entities.commande.Commande;

public class CrudHandler {
    private IDbServiceInput dbServiceInput;
    private IDbServiceOutput dIDbServiceOutput;
    private IFileServiceOutput fileServiceOutput;

    public CrudHandler(IDbServiceInput dbServiceInput, IDbServiceOutput dbServiceOutput,
            IFileServiceOutput fileServiceOutput) {
        if (dbServiceInput == null || dbServiceOutput == null) {
            throw new IllegalArgumentException();
        }

        this.dbServiceInput = dbServiceInput;
        this.dIDbServiceOutput = dbServiceOutput;
        this.fileServiceOutput = fileServiceOutput;
    }

    public void createCommande(Commande commandeToSave) {
        if (commandeToSave == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.createCommande(commandeToSave);
    }

    public void annulerCommande(Commande commande) {
        if (commandeToSave == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.annulerCommande(commande);
    }

    public void addArticleCommande(Commande commande, Article article) {
        if (commande == null || article == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.addArticleCommande(commande, article);
    }

    public void removeArticleCommande(Commande commande, Article article) {
        if (commande == null || article == null) {
            throw new IllegalArgumentException();
        }

        dIDbServiceOutput.removeArticleCommande(commande, article);
    }

    public void getCommande(Commande commande) {
        if (commande == null) {
            throw new IllegalArgumentException();
        }

        IDbServiceInput.getCommande(commande);
    }

    public void getPrixTotal(Commande commande) {
        if (commande == null) {
            throw new IllegalArgumentException();
        }

        IDbServiceInput.getPrixTotal(commande);
    }

    public void getCommandes() {
        IDbServiceInput.getCommandes();
    }

}
