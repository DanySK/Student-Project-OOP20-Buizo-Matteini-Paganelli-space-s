package spacesurvival.view.pause;

import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.utilities.BtnAction;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

public interface GUIPause extends GUI {

    BtnAction getActionBtn(int ind);

    void setNameButtons(List<String> listNames);

    void setActionButtons(ActionGUI mainAction, List<ActionGUI> linksID);


    void setFontGUITitle(Font font);

    void setTitleGUI(String title);

    void setForegroundGUI(Color color);

    void setFontButtons(Font font);

    void setBackgroundButtons(Color color);

}
