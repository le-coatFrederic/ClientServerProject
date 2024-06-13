package domain.entities.facture;

import java.time.LocalDateTime;
import java.util.ArrayList;

import domain.entities.article.Article;
import domain.entities.paiement.PaiementMethod;

public class Facture {
	private int numero;
	private ArrayList<Article> articles;
	private LocalDateTime creationDateTime;
	private PaiementMethod moyenPaiement;

	public Facture(int numero) {
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