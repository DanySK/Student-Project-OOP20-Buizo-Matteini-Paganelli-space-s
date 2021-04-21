package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.game.EngineGame;
import view.GUI.GUI;
import view.GUI.game.GUIGame;

public class CtrlGame implements ControllerGUI{
    private final EngineGame engine;
    private final GUIGame gui;

    public CtrlGame(final EngineGame engine, final GUIGame gui){
        this.engine = engine;
        this.gui = gui;
        this.init();
    }

    private void init(){
        this.gui.setId(this.engine.getId());
        this.gui.setVisible(this.engine.isVisible());
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }
}
