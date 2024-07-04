package heptathlon.domain.usecase.display;

public class DisplayManager {
    private IPresenter presenter;

    public DisplayManager(IPresenter presenter) {
        this.presenter = presenter;
    }

    
}
