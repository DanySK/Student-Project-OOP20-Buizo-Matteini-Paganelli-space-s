package spaceSurvival.view.GUI.menu;

import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;
import spaceSurvival.view.utilities.ButtonID;

import java.util.List;

public interface GUIMenu extends GUI, GraphicsGUIMenu{

    public void setNameButtons(final List<String> listNames);

    public void setIdButtons(final List<IdGUI> linksID);

    public ButtonID getButton(final int ind);
}
