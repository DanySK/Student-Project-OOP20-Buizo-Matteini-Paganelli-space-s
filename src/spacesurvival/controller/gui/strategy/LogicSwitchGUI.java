package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.utilities.LinkActionGUI;

import java.util.Map;

/**
 * Implement functions for GUI switching logic.
 */
public interface LogicSwitchGUI {
    /**
     * Function logic for change GUI.
     * 
     * @param actionCurrent is current GUI.
     * @param actionNext is next GUI.
     * @param chronology is a list of sequence GUI.
     * @param control is each control GUI.
     */
    void algorithm(LinkActionGUI actionCurrent, LinkActionGUI actionNext,
                   ListGUI<LinkActionGUI> chronology, Map<LinkActionGUI, ControllerGUI> control);
}
