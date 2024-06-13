package usecase;

import java.util.List;

import domain.entity.Article;
import domain.value.FamilleArticle;

public interface  IArticleListe {
    public List<Article> getAllArticle();
    public List<Article> getAllArticleByFamilies(List<FamilleArticle> families);
    public List<Article> getAllArticlePrixSup(double prix);
    public List<Article> getAllArticlePrixInf(double prix);
    public List<Article> getAllArticlePrix(double prix);
    public List<Article> getAllArticlePrixBetween(double prixInf, double prixSup);
    public List<Article> getAllArticleQteSup(int qte);
    public List<Article> getAllArticleQteInf(int qte);
    public List<Article> getAllArticleQte(int qte);
    public List<Article> getAllArticleQteBetween(int qteInf, int qteSup);
    public List<Article> getAllArticleByName(String name);
}
