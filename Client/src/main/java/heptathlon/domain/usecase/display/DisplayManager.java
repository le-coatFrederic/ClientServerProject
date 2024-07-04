package heptathlon.domain.usecase.display;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;

public class DisplayManager {

    public DisplayManager() {
        this.start();
    }

    public void showMenu() {
        System.out.println("Veuillez choisir une option:");
        System.out.println("1. Chercher un article par rapport à son nom");
        System.out.println("2. Afficher les stocks d'article");
        System.out.println("3. Créer une commande");
        System.out.println("\u001B[31m" + "4. Quitter" + "\u001B[0m");
        System.out.print("Entrez votre choix (1/2/3/4): ");
    }

    public void showAllArticle(List<ArticleAndCategoryDTO> articles) {
        articles.forEach(article -> {
            System.out.println("ID  " + article.getId() + " : Article : " + article.getIntitule());
        });
    }

    public void showSearchMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSearchMenu'");
    }

    public void start() {
        this.showMenu();

    }
}
