package spacesurvival.view.help;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

public interface GUIHelp extends GUI {

    void setActionBtnBack(LinkActionGUI mainAction, LinkActionGUI intoID);

    void setNameUnit(List<String> listName);

    void setBtnNames(List<String> listName);

    void addNameAndIconInUnit(String panelName, List<EngineImage> pathImg);


    void setTitleGUI(String title);

    void setForegroundGUI(Color color);

    void setFontTitleGUI(Font font);

    void setFontGUI(Font font);
}
