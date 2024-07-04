package heptathlon.application.display;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.usecase.IController;
import heptathlon.domain.usecase.IDisplay;

public class TerminalPresenter implements IDisplay {

    @Override
    public void showAllArticle(List<ArticleAndCategoryDTO> articles) {
        articles.forEach(article -> {
            System.out.println(article);
        });
    }

    @Override
    public void showMenu() {
        System.out.println("Veuillez choisir : \n1/Creer une commande\n2/Voir tous les articles\n3/Faire une recherche");
    }

    @Override
    public void showSearchMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSearchMenu'");
    }

}
