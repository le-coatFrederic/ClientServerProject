package domain.entities.entreposer;

import java.io.ObjectInputStream.GetField;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;

import javax.lang.model.element.QualifiedNameable;

import domain.entities.article.IArticleHandler;
import domain.entities.entrepot.IEntrepot;

public class Entreposer {
	private IArticleHandler article;
	private IEntrepot entrepot;
	private int quantity;
	
	public Entreposer( IArticleHandler article, IEntrepot entrepot) {
		this.article = article;
		this.entrepot = entrepot;
	}
	
	public IArticleHandler getArticle() {
		return article;
	}
	
	public IEntrepot getEntrepot () {
		return entrepot;
	}
	
	public void setArticle (IArticleHandler article) {
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
