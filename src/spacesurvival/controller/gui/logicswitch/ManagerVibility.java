package spacesurvival.controller.gui.logicswitch;

import spacesurvival.controller.gui.ManagerControllerGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;

public class ManagerVibility implements LogicSwitchGUI {
    private final ManagerControllerGUI managerControllerGUI;

    public ManagerVibility(final ManagerControllerGUI managerControllerGUI) {
        this.managerControllerGUI = managerControllerGUI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void algorithmSwitchNormal(final LinkActionGUI actionCurrent, final LinkActionGUI actionNext) {
        switch (actionNext) {
        case LINK_MENU:
        case LINK_GAME:
            this.managerControllerGUI.getChronology().add(actionNext);
            this.managerControllerGUI.getManagerGui().get(actionNext).turn(Visibility.VISIBLE);
            this.managerControllerGUI.getChronology().remove(actionCurrent);
            this.managerControllerGUI.getManagerGui().get(actionCurrent).turn(Visibility.HIDDEN);
            break;

        case LINK_BACK:
            this.managerControllerGUI.getManagerGui().get(actionCurrent).turn(Visibility.HIDDEN);
            this.managerControllerGUI.getCurrentGUI()
            .ifPresent(link -> this.managerControllerGUI.getChronology().remove(link));
  
            break;

        default:
            this.managerControllerGUI.getChronology().add(actionNext);
            this.managerControllerGUI.getManagerGui().get(actionNext).turn(Visibility.VISIBLE);
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
            if (!this.managerControllerGUI.getCurrentGUI().get().equals(LinkActionGUI.LINK_PAUSE)) {
                this.managerControllerGUI.getChronology().add(actionNext);
            } else {
                this.managerControllerGUI.getChronology().remove(actionNext);
            }

            this.managerControllerGUI.getManagerGui().get(actionNext).changeVisibility(); break;

        case LINK_BACK:
                
            this.managerControllerGUI.getManagerGui().get(actionCurrent).turn(Visibility.HIDDEN);
            this.managerControllerGUI.getCurrentGUI()
                .ifPresent(link -> this.managerControllerGUI.getChronology().remove(link));
            
            this.managerControllerGUI.getCurrentGUI()
                .ifPresent(link -> this.managerControllerGUI.getManagerGui().get(link).turn(Visibility.VISIBLE));
            break;

        default:
            this.managerControllerGUI.getChronology().add(actionNext);
            this.managerControllerGUI.getManagerGui().get(actionNext).turn(Visibility.VISIBLE);
            this.managerControllerGUI.getManagerGui().get(actionCurrent).turn(Visibility.HIDDEN);
            break;
    }

    }
}
