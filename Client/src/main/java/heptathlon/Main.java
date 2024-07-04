package heptathlon;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.application.display.TerminalControllerImpl;
import heptathlon.application.display.TerminalPresenterImpl;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.usecase.display.DisplayManager;
import heptathlon.domain.usecase.display.IController;
import heptathlon.domain.usecase.display.IPresenter;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIP = "localhost:30000";
            IRmiSenderToClient communicationService = (IRmiSenderToClient) Naming
                    .lookup("//" + serverIP + "/ClientGet");
            Scanner sc = new Scanner(System.in);

            IController controller = new TerminalControllerImpl();
            IPresenter presenter = new TerminalPresenterImpl();
            DisplayManager displayManager = new DisplayManager(presenter);

            int choice;
            presenter.showMenu();

            do {
                
                choice = sc.nextInt();

                switch (choice) {

                    case 1 -> {
                    }
                    case 2 -> {
                        List<ArticleAndCategoryDTO> articleList = communicationService.getAllArticles();
                        new TerminalPresenterImpl().showAllArticle(articleList);
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