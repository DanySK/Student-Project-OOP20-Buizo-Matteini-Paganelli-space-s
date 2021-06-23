package spacesurvival.controller.gui.strategy;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;

import java.util.Map;

public class LogicSwitchGame implements LogicSwitchGUI {
    @Override
    public void algorithm(final LinkActionGUI actionCurrent, final LinkActionGUI actionNext,
                          final ListGUI<LinkActionGUI> chronology, final Map<LinkActionGUI, ControllerGUI> manager) {

        switch (actionNext) {
            case ID_PAUSE:
                if (chronology.lastElementOfList().get() != LinkActionGUI.ID_PAUSE) {
                    chronology.add(actionNext);
                } else {
                    chronology.remove(actionNext);
                }

                manager.get(actionNext).changeVisibility(); break;

            case ID_BACK:
                    manager.get(actionCurrent).turn(Visibility.HIDDEN);
                    chronology.lastElementOfList().ifPresent(chronology::remove);
                    chronology.lastElementOfList().ifPresent(link -> manager.get(link).turn(Visibility.VISIBLE));
                break;
            case ID_QUIT: 
                Syste
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
