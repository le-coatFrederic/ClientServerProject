package usecase.article.communication;

import java.util.ArrayList;

import domain.entities.article.Article;
import domain.values.Categorie;
import domain.values.EAN;

public interface IClientCommunicator {
    public void magasinSendArticle(EAN ean);
    public void magasinSendArticle(String ean);
    public void magasinSendAllArticle();
    public void magasinSendFamilies();
    public void magasinSendEans();
}
