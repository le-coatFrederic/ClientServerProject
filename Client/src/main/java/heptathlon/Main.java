package heptathlon;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.usecase.display.DisplayManager;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIP = "localhost:30000";
            IRmiSenderToClient communicationService = (IRmiSenderToClient) Naming
                    .lookup("//" + serverIP + "/ClientGet");
            Scanner sc = new Scanner(System.in);

            DisplayManager displayManager = new DisplayManager();

            int choice;

            do {
                displayManager.showMenu();
                choice = sc.nextInt();

                switch (choice) {

                    case 1 -> {
                        System.out.println("Cherchez un article avec son nom");
                        String name = sc.next();
                        List<ArticleAndCategoryDTO> foundArticles = communicationService.getAllArticlesByIntitules(
                                name);
                        foundArticles.forEach(article -> {
                            System.out.println("ID  " + article.getId() + " : Article : " + article.getIntitule());
                        });
                    }
                    case 2 -> {
                        List<ArticleAndCategoryDTO> articleList = communicationService.getAllArticles();
                        displayManager.showAllArticle(articleList);
                    }
                    case 3 -> {

                    }
                    case 4 -> System.out.println("Quitter le programme...");
                    default -> System.out.println("Choix invalide, veuillez réessayer.");

                }

            } while (choice != 4);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}