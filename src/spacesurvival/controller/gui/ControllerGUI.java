package spacesurvival.controller.gui;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;

public interface ControllerGUI {

    void assignAction();

    void assignStrings();

    void assignRectangle();


    LinkActionGUI getMainAction();

    GUI getGUI();

    EngineGUI getEngine();


    boolean isVisibility();

    void turn(Visibility visibility);

    void changeVisibility();

    void closeGUI();
}
