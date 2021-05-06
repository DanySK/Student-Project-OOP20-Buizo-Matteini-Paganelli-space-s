package controller.GUI;

import controller.GUI.command.SwitchGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.scoreboard.EngineScoreboard;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.scoreboard.GUIScoreboard;

public class CtrlScoreboard implements ControllerGUI {
    private final GUIScoreboard gui;
    private final EngineScoreboard engine;

    private final SwitchGUI switchGUI;

    public CtrlScoreboard(final EngineScoreboard engine, final GUIScoreboard gui){
        this.gui = gui;
        this.engine = engine;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void assignId(){
        this.gui.setId(this.engine.getId());
        this.gui.setBtnBackID(this.engine.getBackLink());
    }

    private void assignStrings(){
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListName());
    }

    @Override
    public IdGUI getId() {
        return this.engine.getId();
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
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }
}
