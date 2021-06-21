package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.utilities.LinkActionGUI;

import java.util.Map;


public interface LogicSwitchGUI {
    void algorithm(LinkActionGUI actionCurrent, LinkActionGUI actionNext,
                   ListGUI<LinkActionGUI> listLinkActionGUI, Map<LinkActionGUI, ControllerGUI> control);

    default void quit() {
        System.exit(0);
    }
}
