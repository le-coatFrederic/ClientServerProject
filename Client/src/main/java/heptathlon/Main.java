package heptathlon;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.application.display.TerminalPresenter;
import heptathlon.domain.dto.ArticleAndCategoryDTO;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIP = "localhost:1099";
            IRmiSenderToClient communicationService = (IRmiSenderToClient) Naming
                    .lookup("//" + serverIP + "/ClientGet");
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Veuillez choisir une option:");
                System.out.println("1. Chercher un article");
                System.out.println("2. Afficher les stocks d'article");
                System.out.println("3. Créer une commande");
                System.out.println("\u001B[31m" + "4. Quitter" + "\u001B[0m");
                System.out.print("Entrez votre choix (1/2/3/4): ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1 -> {
                    }
                    case 2 -> {
                        List<ArticleAndCategoryDTO> articleList = communicationService.getAllArticles();
                        new TerminalPresenter().showAllArticle(articleList);
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