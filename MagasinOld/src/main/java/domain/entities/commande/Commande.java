package src.main.java.domain.entities.commande;

import java.time.LocalDateTime;
import java.util.ArrayList;

import src.main.java.domain.entities.article.Article;
import src.main.java.domain.entities.paiement.PaiementMethod;

public class Commande {
	private int numero;
	private ArrayList<Article> articles;
	private LocalDateTime creationDateTime;
	private PaiementMethod moyenPaiement;

	public Commande(int numero) {
		this.numero = numero;
		creationDateTime = LocalDateTime.now();
		articles = new ArrayList<Article>();
	}

	public int getNumero() {
		return numero;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public LocalDateTime getDateCreationDateTime() {
		return creationDateTime;
	}

	public PaiementMethod getMoyenPaiement() {
		return moyenPaiement;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	public void setCreationDateTime(LocalDateTime date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}

		this.creationDateTime = date;
	}

	public void setMoyenPaiement(PaiementMethod moyenPaiement) {
		if (moyenPaiement == null) {
			throw new IllegalArgumentException();
		}

		this.moyenPaiement = moyenPaiement;
	}

	public float totalMoney() {
		float money = 0;

		for (Article article : articles) {
			money += article.getPrice() * article.getQuantity();
		}

		return money;
	}

	public int totalQuantity() {
		int quantity = 0;

		for (Article article : articles) {
			quantity += article.getQuantity();
		}

		return quantity;
	}

}