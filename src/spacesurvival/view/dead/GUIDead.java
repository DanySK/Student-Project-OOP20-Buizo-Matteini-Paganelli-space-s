package spacesurvival.view.dead;

import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

public interface GUIDead extends GUI {

    void setNameButtons(List<String> listNames);

    void setBtnActions(LinkActionGUI mainAction, List<LinkActionGUI> actions);


    void setFontTitleGUI(Font font);

    void setTitleGUI(String title);

    void setForegroundTitle(Color color);

    void setFontGUI(Font font);

    void setForegroundGUI(Color color);

    void setBorder(Color color, int thickness);
}
