package heptathlon.domain.usecase.display;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;

public interface IPresenter {
    void showMenu();
    void showSearchMenu();
    void showAllArticle(List<ArticleAndCategoryDTO> articles);
}
