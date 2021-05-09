package controller.GUI;

import controller.GUI.command.SwitchGUI;
import factorys.StaticFactoryEngineGUI;
import factorys.StaticFactoryGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.pause.EnginePause;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.pause.GUIPause;

public class CtrlPause implements ControllerGUI{
    private final EnginePause engine;
    private final GUIPause gui;

    private final SwitchGUI switchGUI;

    public CtrlPause(final EnginePause engine, final GUIPause gui){
        this.engine = engine;
        this.gui = gui;

        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();

        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void assignId(){
        this.gui.setId(this.engine.getId());
        this.gui.setIdButtons(this.engine.getLinks());
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
    public void turn(Visibility visibility) {
        this.switchGUI.turn(visibility);
    }
}
