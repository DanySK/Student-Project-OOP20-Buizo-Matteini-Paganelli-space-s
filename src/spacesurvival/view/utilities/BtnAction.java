package spacesurvival.view.utilities;

import spacesurvival.utilities.LinkActionGUI;

import javax.swing.JButton;

public class BtnAction extends JButton {
    private LinkActionGUI actionCurrent;
    private LinkActionGUI actionNext;

    public BtnAction() {
        super();
    }

    public LinkActionGUI getActionCurrent() {
        return this.actionCurrent;
    }

    public LinkActionGUI getActionNext() {
        return this.actionNext;
    }


    public void setActionCurrent(final LinkActionGUI currentGUIID) {
        this.actionCurrent = currentGUIID;
    }

    public void setActionNext(final LinkActionGUI linkActionGUINext) {
        this.actionNext = linkActionGUINext;
    }


    @Override
    public String toString() {
        return "BtnAction{"
                + "actionCurrent=" + actionCurrent 
                + ", actionNext=" + actionNext 
                + '}';
    }
}
