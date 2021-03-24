package view.utilities;

import utilities.IdGUI;

import javax.swing.*;
import java.awt.*;

public class ButtonID extends JButton {
    private IdGUI currentIdGUI;
    private IdGUI commandIdGUI;

    public ButtonID(){
        super();
    }

    public IdGUI getCurrentGUIID() {
        return currentIdGUI;
    }

    public void setCurrentGUIID(IdGUI currentGUIID) {
        this.currentIdGUI = currentGUIID;
    }

    public IdGUI getCommandIdGUI() {
        return commandIdGUI;
    }

    public void setCommandIdGUI(IdGUI commandIdGUI) {
        this.commandIdGUI = commandIdGUI;
    }

    @Override
    public String toString() {
        return "ButtonID{" +
                "currentGUIID=" + currentIdGUI +
                ", intoGUIID=" + commandIdGUI +
                '}';
    }

}
