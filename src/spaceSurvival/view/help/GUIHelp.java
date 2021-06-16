package spacesurvival.view.help;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;

import java.util.List;

public interface GUIHelp extends GUI, GraphicsGUIHelp {

    public void setActionBtnBack(final ActionGUI mainAction, final ActionGUI intoID);

    public void setNameUnit(final List<String> listName);

    public void setBtnNames(final List<String> listName);

    public void addNameAndIconInUnit(final String panelName, final List<EngineImage> pathImg);
}
