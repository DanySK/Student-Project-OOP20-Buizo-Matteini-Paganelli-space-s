package view.GUI.pause;

import utilities.IdGUI;
import view.GUI.GUI;
import view.utilities.ButtonID;

import java.util.List;

public interface GUIPause extends GUI, GraphicsGUIPause {

    public void setNameButtons(final List<String> listNames);

    public void setIdButtons(final List<IdGUI> linksID);

    public ButtonID getButton(final int ind);
}
