package heptathlon.domain.usecase;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;

public interface IDisplay {
    void showMenu();
    void showSearchMenu();
    void showAllArticle(List<ArticleAndCategoryDTO> articles);
}
