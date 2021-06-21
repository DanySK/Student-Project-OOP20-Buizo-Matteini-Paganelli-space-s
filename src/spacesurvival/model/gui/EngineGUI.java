package spacesurvival.model.gui;

import spacesurvival.utilities.LinkActionGUI;

import java.awt.Rectangle;
import java.util.List;

public interface EngineGUI {

    /**
     * Return the main action for this gui.
     * 
     * @return the main action of type ActionGUI
     */
    LinkActionGUI getMainAction();

    /**
     * Return the rectangle represent the gui.
     * 
     * @return a Rectangle
     */
    Rectangle getRectangle();

    /**
     * Return the state of the visibility of the gui.
     * 
     * @return a Visibility enum
     */
    Visibility getVisibility();

    /**
     * Return a list of possible links of the gui.
     * 
     * @return a list of ActionGUI
     */
    List<LinkActionGUI> getLinks();

    /**
     * Set the visibility of the gui.
     * 
     * @param state the state to set
     */
    void setVisibility(Visibility state);

    /**
     * Return a boolean representing the visibility of the gui.
     * 
     * @return true is the gui is visible
     */
    boolean isVisible();

}
