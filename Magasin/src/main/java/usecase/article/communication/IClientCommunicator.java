package usecase.article.communication;

import domain.values.EAN;

public interface IClientCommunicator {
    public void sendArticle(EAN ean);
    public void sendArticle(String ean);
    public void sendAllArticle();
    public void sendFamilies();
    public void sendEans();
}
