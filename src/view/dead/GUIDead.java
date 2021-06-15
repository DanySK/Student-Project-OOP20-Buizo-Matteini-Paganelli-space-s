package view.dead;

import utilities.ActionGUI;
import view.GUI;


import java.util.List;

public interface GUIDead extends GUI, GraphicsGUIDead {

    public void setNameButtons(final List<String> listNames);

    public void setBtnActions(final ActionGUI mainAction, final List<ActionGUI> actions);
}
