package application.dbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.standard.JobOriginatingUserName;

import domain.entities.article.Article;
import domain.values.EAN;
import usecase.crudArticle.ArticleCRUDOperation;
import usecase.crudArticle.IArticleDBInput;
import usecase.crudArticle.IArticleDBOutput;

public class dbHandler implements IArticleDBOutput, IArticleDBInput{
	private String urlString = "jdbc:mysql//10.0.0.10:32768/clientServeurMagasin";
	private String username = "upjv";
	private String password = "Upjv2024*";
	private Connection dbConnection = null;
	private Statement statement = null;
	
	private Connection setConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(urlString, username, password);
			System.out.println("Connection " + urlString + "using " + username + " is complete!");
			statement = dbConnection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	private ResultSet query(String queryString ) {
		if (statement == null) {
			dbConnection = setConnection();
		}
		
		ResultSet result = null;
		
		try {
			result = statement.executeQuery(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public void createArticle(Article newArticle) {
		if (dbConnection == null || statement == null) {
			dbConnection = setConnection();
		}
		
		System.out.println("creating " + newArticle);
		query("insert into article (`" + newArticle.getId() + "`,`" + newArticle.getEan().getEan() + "`,`" + newArticle.getName() + "`,`" + newArticle.getDescription() + "`,`" + newArticle.getPrice() + "`,`" + newArticle.getCategorie().getCategorie() + "`,)");
	}

	@Override
	public void updateArticle(Article oldArticle, Article newArticle) {
		System.out.println("changed " + oldArticle + " by " + newArticle);
		
	}

	@Override
	public void removeArticle(Article article) {
		System.out.println("removing " + article);
	    //articles.remove(article.getId());
	}

	@Override
	public Article getArticle(int id) {
		return new Article(id, new ArticleCRUDOperation(this, this)); // TODO
	}

	@Override
	public Article getArticle(EAN ean) {
		return new Article(0, new ArticleCRUDOperation(this, this)); // TODO
		
	}

	@Override
	public int getNextId() {
		return 0;
	}

}
