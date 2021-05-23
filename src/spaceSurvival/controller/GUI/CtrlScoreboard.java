package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.scoreboard.EngineScoreboard;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.scoreboard.GUIScoreboard;

public class CtrlScoreboard implements ControllerGUI {
    private final GUIScoreboard gui;
    private final EngineScoreboard engine;

    private final SwitchGUI switchGUI;

    public CtrlScoreboard(final EngineScoreboard engine, final GUIScoreboard gui){
        this.gui = gui;
        this.engine = engine;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    @Override
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setBtnBackID(this.engine.getMainAction(), this.engine.getBackLink());

    }

    @Override
    public void assignStrings(){
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListName());
    }

    @Override
    public void assignRectangle() {
        this.gui.setBounds(this.engine.getRectangle());
    }

    @Override
    public ActionGUI getMainAction() {
        return this.engine.getMainAction();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }
}
