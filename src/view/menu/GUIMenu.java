package view.menu;

import utilities.ActionGUI;
import view.GUI;

import java.util.List;

public interface GUIMenu extends GUI, GraphicsGUIMenu{

    public void setNameButtons(final List<String> listNames);

    public void setBtnActions(final ActionGUI mainAction, final List<ActionGUI> linksID);


}
