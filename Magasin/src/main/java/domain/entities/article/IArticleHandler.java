package domain.entities.article;

public interface IArticleHandler {
	public Article createArticle();
	public Article updateArticle(int oldArticleId, Article newArticle);
	public Article detailArticle(int id);
	public Article removeArticle(int id);
}
