package spacesurvival.view.scoreboard;

import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI, GraphicsScoreboardGUI {

    void setNameButtons(List<String> listName);

    void setBtnBackID(ActionGUI mainAction, ActionGUI action);

}
