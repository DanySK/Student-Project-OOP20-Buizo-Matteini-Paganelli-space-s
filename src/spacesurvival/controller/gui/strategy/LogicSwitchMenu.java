package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;

import java.util.Map;

public class LogicSwitchMenu implements LogicSwitchGUI {

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
                chronology.remove(chronology.lastElementOfList());
                break;

            case ID_QUIT: this.quit(); break;

            default:
                chronology.add(actionNext);
                manager.get(actionNext).turn(Visibility.VISIBLE);
                break;
        }
    }
}
