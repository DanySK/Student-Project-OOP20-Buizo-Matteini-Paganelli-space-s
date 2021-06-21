package spacesurvival.view.menu;

import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

public interface GUIMenu extends GUI {

    void setNameButtons(List<String> listNames);

    void setBtnActions(LinkActionGUI mainAction, List<LinkActionGUI> linksID);


    void setFontTitleGUI(Font font);

    void setTitleGUI(String title);

    void setFontGUI(Font font);

    void setForegroundGUI(Color color);

    void setBorder(Color color, int thickness);

    void setColumnsNamePlayer(int sizeColumn);
}
