package controller.GUI;

import controller.GUI.command.SwitchGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.menu.EngineMenu;
import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.menu.GUIMenu;

public class CtrlMenu implements ControllerGUI {
    private GUIMenu gui;
    private EngineMenu engine;

    private final SwitchGUI switchGUI;

    public CtrlMenu(final EngineMenu menuEngine, final GUIMenu menuGUI){
        this.gui = menuGUI;
        this.engine = menuEngine;
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
    public void turn(final Visibility visibility){
        this.switchGUI.turn(visibility);
    }
}
