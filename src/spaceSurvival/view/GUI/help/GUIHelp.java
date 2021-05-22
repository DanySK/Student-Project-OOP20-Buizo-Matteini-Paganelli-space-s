package spaceSurvival.view.GUI.help;

import spaceSurvival.model.ImageDesign;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;

import java.util.List;

public interface GUIHelp extends GUI, GraphicsGUIHelp {

    public void setIdBtnBack(final IdGUI intoID);

    public void setNameUnitHelps(final List<String> listName);

    public void setNameButtons(final List<String> listName);

    public void addIconInUnitHelp(final String panelName, final List<ImageDesign> pathImg);
}
