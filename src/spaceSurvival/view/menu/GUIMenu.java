package spaceSurvival.view.menu;

import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.utilities.BtnAction;

import java.util.List;

public interface GUIMenu extends GUI, GraphicsGUIMenu{

    public void setNameButtons(final List<String> listNames);

    public void setBtnActions(final ActionGUI mainAction, final List<ActionGUI> linksID);


}
