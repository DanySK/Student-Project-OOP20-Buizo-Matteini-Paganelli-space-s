package view.GUI.menu;

import utilities.IdGUI;
import view.GUI.GUI;
import view.utilities.ButtonID;

import javax.swing.*;
import java.util.List;

public interface GUIMenu extends GUI, GraphicsGUIMenu{

    public void setNameButtons(final List<String> listNames);

    public void setIDButtons(final List<IdGUI> linksID);

    public JLabel getLbTitle();

    public JTextField getTxfNamePlayer();

    public ButtonID getButton(final int ind);
}
