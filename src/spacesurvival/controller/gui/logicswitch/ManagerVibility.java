package spacesurvival.controller.gui.logicswitch;

import java.util.Map;

import spacesurvival.controller.gui.ControllerGUI;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;

public class ManagerVibility implements LogicSwitchGUI {
    private final ListGUI<LinkActionGUI> chronology;
    private final Map<LinkActionGUI, ControllerGUI> managerGui;

    public ManagerVibility(final ListGUI<LinkActionGUI> chronology, final Map<LinkActionGUI, ControllerGUI> managerGui) {
        this.chronology = chronology;
        this.managerGui = managerGui;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void algorithmSwitchNormal(final LinkActionGUI actionCurrent, final LinkActionGUI actionNext) {
        switch (actionNext) {
        case LINK_MENU:
        case LINK_GAME:
            chronology.add(actionNext);
            managerGui.get(actionNext).turn(Visibility.VISIBLE);
            chronology.remove(actionCurrent);
            managerGui.get(actionCurrent).turn(Visibility.HIDDEN);
            break;

        case LINK_BACK:
            managerGui.get(actionCurrent).turn(Visibility.HIDDEN);
            chronology.lastElementOfList().ifPresent(chronology::remove);
            break;
        case LINK_QUIT: 
            managerGui.values().forEach(ControllerGUI::closeGUI);
            break;
        default:
            chronology.add(actionNext);
            break;
    }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void algorithmSwitchGame(final LinkActionGUI actionCurrent, final LinkActionGUI actionNext) {
        switch (actionNext) {
        case LINK_PAUSE:
            if (chronology.lastElementOfList().get() != LinkActionGUI.LINK_PAUSE) {
                chronology.add(actionNext);
            } else {
                chronology.remove(actionNext);
            }

            managerGui.get(actionNext).changeVisibility(); 
            break;
        case LINK_BACK:
            managerGui.get(actionCurrent).turn(Visibility.HIDDEN);
                chronology.lastElementOfList().ifPresent(chronology::remove);
                chronology.lastElementOfList().ifPresent(link -> managerGui.get(link).turn(Visibility.VISIBLE));
            break;
        case LINK_QUIT: 
            managerGui.values().forEach(ControllerGUI::closeGUI);
            break;

        default:
            chronology.add(actionNext);
            managerGui.get(actionNext).turn(Visibility.VISIBLE);
            managerGui.get(actionCurrent).turn(Visibility.HIDDEN);
            break;
        }

    }
}
