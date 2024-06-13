package usecase.article;

import domain.values.Categorie;
import domain.values.EAN;
import usecase.article.dto.dtoListArticle;

public interface IListArticleUse {
    public dtoListArticle getListArticle();
    public dtoListArticle getListArticleByEAN(EAN ean);
    public dtoListArticle getListArticleByName(String name);
    public dtoListArticle getlListArticleByTag(Categorie[] categories);
}
