package spacesurvival.view.scoreboard;

import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI, GraphicsScoreboardGUI {

    public void setNameButtons(List<String> listName);

    public void setBtnBackID(final ActionGUI mainAction, final ActionGUI action);

}
