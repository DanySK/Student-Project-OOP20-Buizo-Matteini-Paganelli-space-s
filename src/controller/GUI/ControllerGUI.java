package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.ActionGUI;
import view.GUI;

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
