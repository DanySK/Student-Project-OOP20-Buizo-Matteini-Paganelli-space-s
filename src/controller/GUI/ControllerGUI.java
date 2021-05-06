package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.IdGUI;
import view.GUI.GUI;

public interface ControllerGUI {
    public IdGUI getId();

    public GUI getGUI();

    public EngineGUI getEngine();

    public void turn(final Visibility visibility);
}
