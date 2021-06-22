package spacesurvival.controller.gui;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;

/**
 * Implements the methods that all controllers GUI must have.
 */
public interface ControllerGUI {

    /**
     * Assign the links from the model to the GUI.
     */
    void assignAction();

    /**
     * Assign the texts from the modem to the GUI.
     */
    void assignStrings();

    /**
     * Assign the rect angle from the modem to the GUI.
     */
    void assignRectangle();

    /**
     * Get my linkAction. 
     * @return my linkAction.
     */
    LinkActionGUI getMainAction();

    /**
     * Get my GUI.
     * @return my GUI.
     */
    GUI getGUI();

    /**
     * Get my engine.
     * @return my engine.
     */
    EngineGUI getEngine();

    /**
     * Get the visibility of my GUI.
     * @return my visibility.
     */
    boolean isVisibility();

    /**
     * Set visibility of my GUI.
     * 
     * @param visibility the visibility to set
     */
    void turn(Visibility visibility);

    /**
     * Change visibility of GUI. 
     */
    void changeVisibility();

    /**
     * Close my JFrame.
     */
    void closeGUI();
}
