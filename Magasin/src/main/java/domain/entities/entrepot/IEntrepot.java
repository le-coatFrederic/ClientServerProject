package domain.entities.entrepot;

import java.util.ArrayList;
import domain.entities.article.IArticle;

public interface IEntrepot {
	public int getId();
	public ArrayList<IArticle> getArticles();
	public IArticle getArticle(int index);
	public IArticle getArticle(IArticle article);
	public void addArticle(IArticle article);
	public void removeArticle(int index);
	public void removeArticle(IArticle article);
	public String getIntitule();
	public void setIntitule(String intitule);
}