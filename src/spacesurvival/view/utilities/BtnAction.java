package spacesurvival.view.utilities;

import spacesurvival.utilities.ActionGUI;
import javax.swing.JButton;


public class BtnAction extends JButton {
    private ActionGUI actionCurrent;
    private ActionGUI actionNext;

    public BtnAction() {
        super();
    }

    public ActionGUI getActionCurrent() {
        return this.actionCurrent;
    }

    public ActionGUI getActionNext() {
        return this.actionNext;
    }


    public void setActionCurrent(final ActionGUI currentGUIID) {
        this.actionCurrent = currentGUIID;
    }

    public void setActionNext(final ActionGUI actionGUINext) {
        this.actionNext = actionGUINext;
    }


    @Override
    public String toString() {
        return "BtnAction{"
                + "actionCurrent=" + actionCurrent 
                + ", actionNext=" + actionNext 
                + '}';
    }
}
