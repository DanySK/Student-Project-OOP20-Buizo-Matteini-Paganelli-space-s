package view.GUI.scoreboard;

import utilities.IdGUI;
import model.GUI.scoreboard.NameScoreboardGUI;
import view.GUI.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI, GraphicsScoreboardGUI {

    public void setNameButtons(List<String> listName);

    public void setBtnBackID(final IdGUI intoID);

}
