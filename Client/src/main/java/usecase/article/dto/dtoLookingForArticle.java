package usecase.article.dto;

import domain.values.Categorie;
import domain.values.EAN;

public class dtoLookingForArticle {
    private EAN eanToLookFor;   
    private String nameToLookFor;
    private Categorie[] categoriesToLookFor = {};

    public dtoLookingForArticle() {
        eanToLookFor = null;
        nameToLookFor = null;
        categoriesToLookFor = null;
    }

    
}
