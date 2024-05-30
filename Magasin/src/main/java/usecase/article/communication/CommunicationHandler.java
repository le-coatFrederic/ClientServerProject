package usecase.article.communication;

import java.util.ArrayList;

import domain.entities.article.Article;
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

    public void receiveArticleFromServer() {
        
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
