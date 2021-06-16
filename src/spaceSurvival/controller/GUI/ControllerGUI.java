package spacesurvival.controller.gui;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;

public interface ControllerGUI {

    public void assignAction();

    public void assignStrings();

    public void assignRectangle();


    public ActionGUI getMainAction();

    public GUI getGUI();

    public EngineGUI getEngine();


    public boolean isVisibility();

    public void turn(final Visibility visibility);

    public void changeVisibility();

    public void closeGUI();
}
