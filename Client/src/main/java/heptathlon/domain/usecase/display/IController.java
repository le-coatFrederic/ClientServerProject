package heptathlon.domain.usecase.display;

import heptathlon.domain.value.ControllerState;

public interface IController {
    void changeState(DisplayManager manager, ControllerState state);
    void getInput(DisplayManager manager, String input);
}
