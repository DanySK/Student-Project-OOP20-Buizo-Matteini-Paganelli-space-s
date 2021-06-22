package spacesurvival.view.menu;

import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

/**
 * Interface that implements the menu functionalities.
 */
public interface GUIMenu extends GUI {

    /**
     * Sets the texts of the menu GUI buttons.
     * @param listNames is list text buttons.
     */
    void setTextButtons(List<String> listNames);

    /**
     * Sets menu links to other GUIs.
     * @param mainAction is connection of the current GUI.
     * @param linksID is connection of the current GUI.
     */
    void setBtnActions(LinkActionGUI mainAction, List<LinkActionGUI> linksID);

    /**
     * Set font title menu GUI.
     * @param font for text.
     */
    void setFontTitleGUI(Font font);

    /**
     * Set title menu GUI.
     * @param title for menu GUI.
     */
    void setTitleGUI(String title);

    /**
     * Set all menu font except title.
     * @param font for menu GUI expect title.
     */
    void setFontGUI(Font font);

    /**
     * Set color foreground menu GUI.
     * @param color for foreground menu GUI.
     */
    void setForegroundGUI(Color color);

    /**
     * Set the space of the JTextField.
     * @param sizeColumn for space JTextField.
     */
    void setColumnsNamePlayer(int sizeColumn);
}
