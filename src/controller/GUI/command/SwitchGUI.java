package controller.GUI.command;

import model.GUI.EngineGUI;
import view.GUI.GUI;

public class SwitchGUI {
    private final CmdEngine onCmdEngine = new CmdON();
    private final CmdEngine offCmdEngine = new CmdOFF();

    public SwitchGUI(){ }

    public void turnOnGUI(final EngineGUI engine, final GUI gui){
        this.onCmdEngine.execute(engine).execute(gui);
    }

    public void turnOffGUI(final EngineGUI engine, final GUI gui){
        this.offCmdEngine.execute(engine).execute(gui);
    }
}
