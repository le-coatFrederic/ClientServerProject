package heptathlon;

import java.rmi.Naming;
import java.util.List;

import heptathlon.application.rmiManager.IRmiSenderToClient;
import heptathlon.domain.dto.ArticleAndCategoryDTO;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIP = "93.8.39.46:9010"; 
            IRmiSenderToClient service = (IRmiSenderToClient) Naming.lookup("//" + serverIP + "/ClientGet");

            List<ArticleAndCategoryDTO> articles = service.getAllArticles();
            articles.forEach(article -> System.out.println(article));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}