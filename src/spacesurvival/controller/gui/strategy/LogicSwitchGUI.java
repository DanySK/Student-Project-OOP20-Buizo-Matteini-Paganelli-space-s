package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.utilities.ActionGUI;

import java.util.Map;


public interface LogicSwitchGUI {
    void algorithm(ActionGUI actionCurrent, ActionGUI actionNext,
                          ListGUI<ActionGUI> listActionGUI, Map<ActionGUI, ControllerGUI> control);

    default void quit() {
        System.exit(0);
    }
}
