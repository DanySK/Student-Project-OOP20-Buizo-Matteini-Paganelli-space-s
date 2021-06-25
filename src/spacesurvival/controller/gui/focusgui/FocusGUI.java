package spacesurvival.controller.gui.focusgui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import spacesurvival.controller.gui.ManagerControllerGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.StateLevelGUI;
import spacesurvival.view.GUI;

public class FocusGUI implements MouseListener {
    private final ManagerControllerGUI control;

    public FocusGUI(final ManagerControllerGUI controll) {
        this.control = controll;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(final MouseEvent e) {
        final LinkActionGUI id = control.getControllerGUIFromGUI((GUI) e.getSource()).get().getMainLink();
        final int indexDifferent = 1;

        if(id.getStateLevel().equals(StateLevelGUI.FOREGROUND) &&
                this.control.getCurrentGUI().get().getStateLevel().equals(StateLevelGUI.OVERLAY)){

            int sizeList = this.control.getChronology().size() - indexDifferent;
            while(this.control.getChronology().get(sizeList).getStateLevel().equals(StateLevelGUI.OVERLAY) ){
                this.control.getManagerGui().get(this.control.getChronology().get(sizeList)).turn(Visibility.HIDDEN);
                this.control.getChronology().remove(sizeList--);
            }
            this.control.getCtrlSound().checkChangeSoundLoop(this.control.getCurrentGUI().get());
            System.out.println("list" + this.control.getChronology());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseEntered(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseExited(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
