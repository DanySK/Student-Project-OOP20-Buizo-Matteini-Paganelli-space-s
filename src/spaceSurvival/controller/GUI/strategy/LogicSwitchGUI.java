package spaceSurvival.controller.GUI.strategy;

import spaceSurvival.controller.GUI.ControllerGUI;
import spaceSurvival.controller.utilities.ListGUI;
import spaceSurvival.utilities.ActionGUI;

import java.util.Map;

public interface LogicSwitchGUI {
    public void algorithm(final ActionGUI actionCurrent, final ActionGUI ActionNext,
                          final ListGUI<ActionGUI> listActionGUI, final Map<ActionGUI, ControllerGUI> control);

    public default void quit() {
        System.exit(0);
    }
}
