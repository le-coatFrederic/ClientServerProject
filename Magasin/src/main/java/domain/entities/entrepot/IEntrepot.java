package domain.entities.entrepot;

import java.util.ArrayList;
import domain.entities.article.IArticleHandler;

public interface IEntrepot {
	public int getId();
	public ArrayList<IArticleHandler> getArticles();
	public IArticleHandler getArticle(int index);
	public IArticleHandler getArticle(IArticleHandler article);
	public void addArticle(IArticleHandler article);
	public void removeArticle(int index);
	public void removeArticle(IArticleHandler article);
	public String getIntitule();
	public void setIntitule(String intitule);
}