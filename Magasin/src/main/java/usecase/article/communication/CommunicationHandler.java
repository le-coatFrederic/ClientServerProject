package usecase.article.communication;

import java.util.ArrayList;

import domain.entities.article.Article;
import domain.values.EAN;
import usecase.article.crud.CrudHandler;

public class CommunicationHandler {
    private CrudHandler crudHandler;
    private IServerCommunicator serverCommunicatorDevice;
    private IClientCommunicator clientCommunicatorDevice;

    public CommunicationHandler(final CrudHandler crudHandler,
    final IServerCommunicator serverCommunicatorDevice,
    final IClientCommunicator clientCommunicatorDevice) {
        if (crudHandler == null || serverCommunicatorDevice == null || clientCommunicatorDevice == null) {
            throw new IllegalArgumentException();
        }

        this.crudHandler = crudHandler;
        this.serverCommunicatorDevice = serverCommunicatorDevice;
    }

    public void receiveArticlesFromServer() {
        ArrayList<Article> articles = serverCommunicatorDevice.getArticles();
        if (articles == null) {
            throw new IllegalArgumentException();
        }

        for (Article article : articles) {
            crudHandler.saveArticle(article);
        }
    }

    public void sendArticlesToServer() {
        ArrayList<Article> articles = crudHandler.getArticles();
        if (articles == null) {
            throw new IllegalArgumentException();
        }

        serverCommunicatorDevice.sendArticles(articles);
    }

    public void sendArticleToClient(EAN ean) {
        if (ean == null) {
            throw new IllegalArgumentException();
        }

        
    }

    public void setCrudHandler(CrudHandler crudHandler) {
        if (crudHandler == null) {
            throw new IllegalArgumentException();
        }

        this.crudHandler = crudHandler;
    }

    public void setServerCommunicatorDevice(IServerCommunicator serverCommunicatorDevice) {
        if (serverCommunicatorDevice == null) {
            throw new IllegalArgumentException();
        }

        this.serverCommunicatorDevice = serverCommunicatorDevice;
    }

    public void setClientCommunicatorDevice(IClientCommunicator ClientCommunicatorDevice) {
        if (ClientCommunicatorDevice == null) {
            throw new IllegalArgumentException();
        }

        this.clientCommunicatorDevice = ClientCommunicatorDevice;
    }        
}
