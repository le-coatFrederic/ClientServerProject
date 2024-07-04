package heptathlon.application.display;

import heptathlon.domain.usecase.display.DisplayManager;
import heptathlon.domain.usecase.display.IController;
import heptathlon.domain.value.ControllerState;

public class TerminalControllerImpl implements IController {
    private ControllerState state;

    public TerminalControllerImpl() {
        state = ControllerState.MAINMENU;
    }

    @Override
    public void changeState(DisplayManager manager, ControllerState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeState'");
    }

    @Override
    public void getInput(DisplayManager manager, String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInput'");
    }

}
