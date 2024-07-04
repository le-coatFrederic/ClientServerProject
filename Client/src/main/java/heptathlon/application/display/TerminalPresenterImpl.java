package heptathlon.application.display;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.usecase.display.IPresenter;

public class TerminalPresenterImpl implements IPresenter {

    @Override
    public void showAllArticle(List<ArticleAndCategoryDTO> articles) {
        articles.forEach(article -> {
            System.out.println(article);
        });
    }

    @Override
    public void showMenu() {
        System.out.println("Veuillez choisir une option:");
        System.out.println("1. Chercher un article");
        System.out.println("2. Afficher les stocks d'article");
        System.out.println("3. Créer une commande");
        System.out.println("\u001B[31m" + "4. Quitter" + "\u001B[0m");
        System.out.print("Entrez votre choix (1/2/3/4): ");
    }

    @Override
    public void showSearchMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSearchMenu'");
    }

}
