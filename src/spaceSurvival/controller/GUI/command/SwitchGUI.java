package spacesurvival.controller.gui.command;

import spacesurvival.model.GUI.EngineGUI;
import spacesurvival.model.GUI.Visibility;
import spacesurvival.view.GUI;

public class SwitchGUI {
    private final CmdEngine onCmdEngine;
    private final CmdEngine offCmdEngine;

    private GUI gui;
    private EngineGUI engine;

    public SwitchGUI(){
        this.onCmdEngine = new CmdON();
        this.offCmdEngine = new CmdOFF();
    }

    public SwitchGUI(final EngineGUI engine, final GUI gui){
        this();
        this.engine = engine;
        this.gui = gui;
    }

    public void setGui(final GUI gui){
        this.gui = gui;
    }
    public void setEngine(final EngineGUI engine){
        this.engine = engine;
    }

    public void turn(final Visibility visibility){
        switch (visibility){
            case HIDDEN: this.offCmdEngine.execute(engine).execute(gui);break;
            case VISIBLE: this.onCmdEngine.execute(engine).execute(gui); break;
        }
    }

    public void changeVisibility(){
        if(this.engine.isVisible()){
            this.offCmdEngine.execute(engine).execute(gui);
        } else {
            this.onCmdEngine.execute(engine).execute(gui);
        }
    }

    public void turnOnGUI(final EngineGUI engine, final GUI gui){
        this.onCmdEngine.execute(engine).execute(gui);
    }

    public void turnOffGUI(final EngineGUI engine, final GUI gui){
        this.offCmdEngine.execute(engine).execute(gui);
    }
}
