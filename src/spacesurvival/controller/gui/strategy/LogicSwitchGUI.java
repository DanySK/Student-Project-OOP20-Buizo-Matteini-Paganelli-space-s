package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.utilities.ActionGUI;

import java.util.Map;


public interface LogicSwitchGUI {
    public void algorithm(final ActionGUI actionCurrent, final ActionGUI actionNext,
                          final ListGUI<ActionGUI> listActionGUI, final Map<ActionGUI, ControllerGUI> control);

    public default void quit() {
        System.exit(1);
    }
}
