package heptathlon;

import java.rmi.Naming;
import java.util.List;
import java.util.Random;

import heptathlon.application.communicationManager.IRmiSenderToClient;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;
import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;
import heptathlon.domain.entity.Invoice;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIP = "localhost:1099"; 
            IRmiSenderToClient communicationService = (IRmiSenderToClient) Naming.lookup("//" + serverIP + "/ClientGet");

            Invoice invoice = new Invoice();
            invoice.setId(new Random().nextInt());
            List<ArticleAndCategoryDTO> articles = communicationService.getAllArticles();
            articles.forEach(articleDTO -> {
                System.out.println(articleDTO);
                Article article = new Article();
                article.setId(articleDTO.getId());
                article.setEan(articleDTO.getEan());
                article.setIntitule(articleDTO.getIntitule());
                article.setPrice(articleDTO.getPrice());
                articleDTO.getCategories().forEach(category -> {
                    Category c = new Category();
                    c.setId(category.getId());
                    c.setIntitule(category.getName());
                    article.addCategory(c);
                });

                invoice.addArticle(article);
            });

            invoice.setFileLink("invoice::" + invoice.getId());
            communicationService.sendInvoice(new InvoiceDTO(invoice));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}