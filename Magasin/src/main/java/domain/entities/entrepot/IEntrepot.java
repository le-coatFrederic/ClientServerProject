package domain.entities.entrepot;

import java.util.ArrayList;
import domain.entities.article.IArticleCRUD;

public interface IEntrepot {
	public int getId();
	public ArrayList<IArticleCRUD> getArticles();
	public IArticleCRUD getArticle(int index);
	public IArticleCRUD getArticle(IArticleCRUD article);
	public void addArticle(IArticleCRUD article);
	public void removeArticle(int index);
	public void removeArticle(IArticleCRUD article);
	public String getIntitule();
	public void setIntitule(String intitule);
}