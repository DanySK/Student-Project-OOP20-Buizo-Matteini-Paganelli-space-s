package spacesurvival.view.scoreboard;

import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

public interface GUIScoreboard extends GUI {

    void setNameButtons(List<String> listName);

    void setBtnBackID(ActionGUI mainAction, ActionGUI action);


    void setTitleGUI(String title);

    void setFontGUI(Font font);

    void setForegroundGUI(Color color);

    void setFontLbTitle(Font font);

}
