package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;

import java.util.Map;

/**
 * Implement functions for GUI switching logic, placing the new GUI on top of the previous one, 
 * and eliminating the next ones except the GUI you started from.
 * Basing the logic on a GUI pauses.
 */
public class LogicSwitchGame implements LogicSwitchGUI {

    /**
     * {@inheritDoc}
     */
    @Override
    public void algorithm(final LinkActionGUI actionCurrent, final LinkActionGUI actionNext,
                          final ListGUI<LinkActionGUI> chronology, final Map<LinkActionGUI, ControllerGUI> manager) {
        System.out.println(actionNext);
        System.out.println("ciaooooooooooooooooooooooooooo");
        switch (actionNext) {
        
            case ID_PAUSE:
                System.out.println("CI PASSO");
                if (chronology.lastElementOfList().get() != LinkActionGUI.ID_PAUSE) {
                    chronology.add(actionNext);
                } else {
                    chronology.remove(actionNext);
                }

                manager.get(actionNext).changeVisibility(); 
                break;
            case ID_BACK:
                    manager.get(actionCurrent).turn(Visibility.HIDDEN);
                    chronology.lastElementOfList().ifPresent(chronology::remove);
                    chronology.lastElementOfList().ifPresent(link -> manager.get(link).turn(Visibility.VISIBLE));
                break;
            case ID_QUIT: 
                    manager.values().forEach(ControllerGUI::closeGUI);
                break;

            default:
                chronology.add(actionNext);
                manager.get(actionNext).turn(Visibility.VISIBLE);
                manager.get(actionCurrent).turn(Visibility.HIDDEN);
                break;
        }
    }

}
