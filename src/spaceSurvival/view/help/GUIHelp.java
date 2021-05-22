package spaceSurvival.view.help;

import spaceSurvival.model.ImageDesign;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;

import java.util.List;

public interface GUIHelp extends GUI, GraphicsGUIHelp {

    public void setIdBtnBack(final ActionGUI intoID);

    public void setNameUnitHelps(final List<String> listName);

    public void setNameButtons(final List<String> listName);

    public void addIconInUnitHelp(final String panelName, final List<ImageDesign> pathImg);
}
