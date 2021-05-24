package spaceSurvival.view.scoreboard;

import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI, GraphicsScoreboardGUI {

    public void setNameButtons(List<String> listName);

    public void setBtnBackID(final ActionGUI mainAction, final ActionGUI action);

}
