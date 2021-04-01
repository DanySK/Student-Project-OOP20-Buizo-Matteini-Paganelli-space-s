package view.utilities;

import utilities.IdGUI;

import javax.swing.*;

public class ButtonID extends JButton {
    private IdGUI idGUICurrent;
    private IdGUI idGUINext;

    public ButtonID(){
        super();
    }

    public IdGUI getIdGUICurrent() {
        return idGUICurrent;
    }

    public void setIdGUICurrent(final IdGUI currentGUIID) {
        this.idGUICurrent = currentGUIID;
    }

    public IdGUI getIdGUINext() {
        return idGUINext;
    }

    public void setIdGUINext(final IdGUI idGUINext) {
        this.idGUINext = idGUINext;
    }

    @Override
    public String toString() {
        return "ButtonID{" +
                "currentGUIID=" + idGUICurrent +
                ", intoGUIID=" + idGUINext +
                '}';
    }

}
