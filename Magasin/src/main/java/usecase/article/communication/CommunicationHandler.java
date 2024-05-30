package usecase.article.communication;

import usecase.article.crud.CrudHandler;

public class CommunicationHandler {
    private CrudHandler crudHandler;
    private IServerCommunicator serverCommunicatorDevice;

    public CommunicationHandler(final CrudHandler crudHandler, final IServerCommunicator serverCommunicatorDevice) {
        if (crudHandler == null || serverCommunicatorDevice == null) {
            throw new IllegalArgumentException();
        }

        this.crudHandler = crudHandler;
        this.serverCommunicatorDevice = serverCommunicatorDevice;
    }

    public CrudHandler getCrudHandler() {
        return crudHandler;
    }

    public void setCrudHandler(CrudHandler crudHandler) {
        if (crudHandler == null) {
            throw new IllegalArgumentException();
        }

        this.crudHandler = crudHandler;
    }

    public IServerCommunicator getCommunicatorDevice() {
        return serverCommunicatorDevice;
    }

    public void setCommunicatorDevice(IServerCommunicator serverCommunicatorDevice) {
        if (serverCommunicatorDevice == null) {
            throw new IllegalArgumentException();
        }

        this.serverCommunicatorDevice = serverCommunicatorDevice;
    } 

    
}
