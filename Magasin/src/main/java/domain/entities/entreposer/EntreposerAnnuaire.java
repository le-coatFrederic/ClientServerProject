package domain.entities.entreposer;

import java.util.ArrayList;

import domain.entities.article.IArticleHandler;
import domain.entities.entrepot.IEntrepot;

public class EntreposerAnnuaire {
	private ArrayList<Entreposer> associationEntreposer;
	
	public EntreposerAnnuaire() {
		associationEntreposer = new ArrayList<Entreposer>();
	}
	
	public void addEntreposer(Entreposer entreposer) {
		if (entreposer == null) {
			throw new NullPointerException();
		}
		
		for (Entreposer association : associationEntreposer) {
			if (association.getEntrepot() == entreposer.getEntrepot()/* && association.getArticle() == entreposer.getArticle()*/ ) {
				association.addArticle(entreposer.getQuantity());
				return;
			}
		}
		
		associationEntreposer.add(entreposer);
	}
	
	public void addEntreposer(IArticleHandler article, IEntrepot entrepot) {
		if (article == null || entrepot == null) {
			throw new IllegalArgumentException();
		}
		
		associationEntreposer.add(new Entreposer(article, entrepot));
	}
}
