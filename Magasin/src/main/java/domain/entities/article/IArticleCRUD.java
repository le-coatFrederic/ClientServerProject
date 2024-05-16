package domain.entities.article;

public interface IArticleCRUD {
	public Article createArticle(int id, IArticleCRUD articleCRUD);
	public Article updateArticle(Article newArticle);
	public Article detailArticle();
	
}
