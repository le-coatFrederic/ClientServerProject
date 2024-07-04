package heptathlon.application.display;

import heptathlon.domain.usecase.IController;
import heptathlon.domain.value.ControllerState;

public class TerminalController implements IController {
    private ControllerState state;

    public TerminalController() {
        state = ControllerState.MAINMENU;
    }

    @Override
    public void changeState(ControllerState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeState'");
    }

    @Override
    public void getInput(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInput'");
    }

}
