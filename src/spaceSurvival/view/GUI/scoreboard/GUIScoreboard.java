package spaceSurvival.view.GUI.scoreboard;

import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI, GraphicsScoreboardGUI {

    public void setNameButtons(List<String> listName);

    public void setBtnBackID(final IdGUI intoID);

}
