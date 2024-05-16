package domain.entities.entreposer;

import java.io.ObjectInputStream.GetField;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;

import javax.lang.model.element.QualifiedNameable;

import domain.entities.article.IArticleCRUD;
import domain.entities.entrepot.IEntrepot;

public class Entreposer {
	private IArticleCRUD article;
	private IEntrepot entrepot;
	private int quantity;
	
	public Entreposer( IArticleCRUD article, IEntrepot entrepot) {
		this.article = article;
		this.entrepot = entrepot;
	}
	
	public IArticleCRUD getArticle() {
		return article;
	}
	
	public IEntrepot getEntrepot () {
		return entrepot;
	}
	
	public void setArticle (IArticleCRUD article) {
		if (article == null) {
			throw new NullPointerException();
		}
		
		this.article = article;
	}
	
	public void setEntrepot (IEntrepot entrepot) {
		if (entrepot == null) {
			throw new NullPointerException();
		}
		
		this.entrepot = entrepot;
	}
	
	public int getQuantity () {
		return quantity;
	}
	
	public synchronized void addArticle(int quantity) {
		this.quantity += quantity;
	}
	
	public synchronized void removeArticle(int quantity) {
		int copyQuantity = this.quantity - quantity;
		if (copyQuantity < 0) {
			throw new InvalidParameterException("This mean that quantity will be negative");
		}
	}
}
