package application;

import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.List;

import application.dbService.dbHandler;
import domain.entities.article.Article;
import domain.values.Categorie;
import domain.values.EAN;
import usecase.crudArticle.ArticleCRUDOperation;

public class Program {
	public static void main(String[] args) {
		try {
			dbHandler db = new dbHandler();
			ArticleCRUDOperation articleOperation = new ArticleCRUDOperation(db, db);

			for (int i = 0; i < 10000000; i++) {
				articleOperation.createArticle();
				Article copyArticle = new Article(-1, articleOperation);
				copyArticle.setCategorie(new Categorie("Volaille"));
				copyArticle.setDescription("Je suis la volaille " + i);
				copyArticle.setEan(new EAN("vol" + i + "aille"));
				copyArticle.setName("VO"+i);
				copyArticle.setPrice((float)1.5);
				
				articleOperation.updateArticle(i, copyArticle);
				System.out.println(articleOperation.detailArticle(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
