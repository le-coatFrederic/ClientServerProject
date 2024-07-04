package heptathlon;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;
import heptathlon.domain.entity.Invoice;
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
                        ArrayList<ArticleAndCategoryDTO> articleList = new ArrayList<>();
                        ArrayList<Integer> listArticlesID = new ArrayList<>();
                        int articleChoice;
                        do {
                            System.out.println("Saisissez l'ID de l'article que vous voulez acheter (0 pour finir)");
                            articleChoice = sc.nextInt();

                            if (articleChoice != 0 && articleChoice < 51) {
                                listArticlesID.add(articleChoice);
                            }
                        } while (articleChoice != 0);

                        listArticlesID.forEach(id -> {
                            try {
                                articleList.add(communicationService.getAllArticles().get(id));
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        });

                        Invoice commande = new Invoice();
                        commande.setId(new Random().nextLong());
                        articleList.forEach(article -> {
                            commande.addArticle(article.toArticle());
                        });
                        commande.setDate(LocalDateTime.now());
                        commande.setFileLink("/");
                        InvoiceDTO invoiceDTO = new InvoiceDTO(commande);
                        communicationService.sendInvoice(invoiceDTO);
                    }
                    case 4 -> System.out.println("Quitter le programme...");
                    default -> System.out.println("Choix invalide, veuillez réessayer.");

                }
                displayManager.showMenu();

            } while (choice != 4);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}