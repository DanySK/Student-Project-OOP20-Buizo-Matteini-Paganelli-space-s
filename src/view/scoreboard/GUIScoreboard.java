package view.scoreboard;

import utilities.ActionGUI;
import view.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI, GraphicsScoreboardGUI {

    public void setNameButtons(List<String> listName);

    public void setBtnBackID(final ActionGUI mainAction, final ActionGUI action);

}
