package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;

import java.util.Map;

/**
 *  Implement functions for GUI switching logic, placing the new GUI on top of the previous one and always returning to the same one.
 */
public class LogicSwitchMenu implements LogicSwitchGUI {

    /**
     * {@inheritDoc}
     */
    @Override
    public void algorithm(final LinkActionGUI actionCurrent, final LinkActionGUI actionNext,
                          final ListGUI<LinkActionGUI> chronology, final Map<LinkActionGUI, ControllerGUI> manager) {

        switch (actionNext) {
            case ID_MENU:
            case ID_GAME:
                chronology.add(actionNext);
                manager.get(actionNext).turn(Visibility.VISIBLE);
                chronology.remove(actionCurrent);
                manager.get(actionCurrent).turn(Visibility.HIDDEN);
                break;

            case ID_BACK:
                manager.get(actionCurrent).turn(Visibility.HIDDEN);
                chronology.lastElementOfList().ifPresent(chronology::remove);
                break;
            case ID_QUIT: 
                manager.values().forEach(ControllerGUI::closeGUI);

                break;
            default:
                chronology.add(actionNext);
                break;
        }
    }
}
