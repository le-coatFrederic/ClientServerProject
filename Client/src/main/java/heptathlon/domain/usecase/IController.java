package heptathlon.domain.usecase;

import heptathlon.domain.value.ControllerState;

public interface IController {
    void changeState(ControllerState state);
    void getInput(String input);
}
