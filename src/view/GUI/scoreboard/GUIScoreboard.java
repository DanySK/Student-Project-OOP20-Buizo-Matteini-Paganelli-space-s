package view.GUI.scoreboard;

import utilities.IdGUI;
import model.GUI.scoreboard.NameScoreboardGUI;
import view.GUI.GUI;

import java.util.List;

public interface GUIScoreboard extends GUI {

    public void setBounds(int x, int y, int width, int height);

    public void setNameButtons(List<NameScoreboardGUI> listName);

    public void setBtnBackID(final IdGUI intoID);

    public void setTitleGUI(final String title);
}
