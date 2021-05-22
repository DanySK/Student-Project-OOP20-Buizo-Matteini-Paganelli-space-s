package spaceSurvival.controller.GUI;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;

public interface ControllerGUI {
    public ActionGUI getIdGUI();

    public GUI getGUI();

    public EngineGUI getEngine();

    public boolean isVisibility();

    public void turn(final Visibility visibility);

    public void changeVisibility();
}
