package spacesurvival.view.menu;

import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

public interface GUIMenu extends GUI {

    void setNameButtons(List<String> listNames);

    void setBtnActions(ActionGUI mainAction, List<ActionGUI> linksID);


    void setFontTitleGUI(Font font);

    void setTitleGUI(String title);

    void setFontGUI(Font font);

    void setForegroundGUI(Color color);

    void setBorder(Color color, int thickness);

    void setColumnsNamePlayer(int sizeColumn);
}
