package spacesurvival.controller.gui.commandfocus;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import spacesurvival.controller.gui.CtrlGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.StateLevelGUI;

public class FocusGUI implements MouseListener{
    private final CtrlGUI control;
    
    public FocusGUI(final CtrlGUI controll) {
        this.control = controll;
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        this.control.getManagerGui().values().forEach(ctrl -> {
            final LinkActionGUI id = ctrl.getMainAction();
            
            if(id.getStateLevel().equals(StateLevelGUI.FOREGROUND) &&
                    this.control.getChronology().lastElementOfList().getStateLevel().equals(StateLevelGUI.OVERLAY)){

                int sizeList =  this.control.getChronology().size() - 1;
                while(this.control.getChronology().get(sizeList).getStateLevel().equals(StateLevelGUI.OVERLAY) ){
                    this.control.getManagerGui().get( this.control.getChronology().get(sizeList)).turn(Visibility.HIDDEN);
                    this.control.getChronology().remove(sizeList--);
                }
                this.control.getCtrlSound().checkChangeSoundLoop(this.control.getChronology().lastElementOfList());
                System.out.println("list" + this.control.getChronology());
            }  
        });
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(final MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
