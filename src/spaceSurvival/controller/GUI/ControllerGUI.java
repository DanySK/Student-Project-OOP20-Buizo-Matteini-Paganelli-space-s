package spaceSurvival.controller.GUI;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;

public interface ControllerGUI {
    public IdGUI getIdGUI();

    public GUI getGUI();

    public EngineGUI getEngine();

    public boolean isVisibility();

    public void turn(final Visibility visibility);

    public void changeVisibility();
}
