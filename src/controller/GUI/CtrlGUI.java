package controller.GUI;

import controller.GUI.Command.CmdEngine;
import controller.GUI.Command.CmdOFF;
import controller.GUI.Command.CmdON;
import model.GUI.EngineGUI;
import utilities.IdGUI;
import view.GUI.GUI;
import view.utilities.ButtonID;

import java.util.ArrayList;
import java.util.List;

public class CtrlGUI {
    private List<IdGUI> crologia = new ArrayList<>();
    private List<EngineGUI> listEngine;
    private List<view.GUI.GUI> listGUI;
    private CmdEngine onCmdEngine = new CmdON();
    private CmdEngine offCmdEngine = new CmdOFF();

    public CtrlGUI(final List<view.GUI.GUI> listGUI, List<EngineGUI> listEngine){
        this.listEngine = listEngine;
        this.listGUI = listGUI;
        this.crologia.add(IdGUI.ID_MENU);
        this.linksAll();
    }

    private void linksAll(){
        for (view.GUI.GUI gui : this.listGUI) {
            for (ButtonID btn : gui.getButtonLinks()) {
                btn.addActionListener(e -> {
                    System.out.println("Premuto in: " + btn.getIdGUICurrent() + " Vado in: " + btn.getIdGUINext());

                    switch (btn.getIdGUINext()) {
                        case ID_QUIT: this.quitAll(); break;
                        case ID_BACK:
                            this.offCmdEngine.execute(this.getEngine(this.lastCrono())).execute(this.getGUI(this.lastCrono()));
                            this.onCmdEngine.execute(this.getEngine(this.penultimateCrono())).execute(this.getGUI(this.penultimateCrono()));
                            this.crologia.remove(this.lastCrono()); break;
                        case ID_SOUND, ID_HELP:
                            this.crologia.add(btn.getIdGUINext());
                            this.onCmdEngine.execute(this.getEngine(this.lastCrono())).execute(this.getGUI(this.lastCrono())); break;
                        default:
                            this.crologia.add(btn.getIdGUINext());
                            this.onCmdEngine.execute(this.getEngine(this.lastCrono())).execute(this.getGUI(this.lastCrono()));
                            this.offCmdEngine.execute(this.getEngine(this.penultimateCrono())).execute(this.getGUI(this.penultimateCrono())); break;
                    }




                    System.out.println("list" + this.crologia);
                });
            }
        }
    }


    private IdGUI lastCrono(){
        return this.crologia.get(this.crologia.size() - 1);
    }

    private IdGUI penultimateCrono(){
        return this.crologia.get(this.crologia.size() - 2);
    }

    private EngineGUI getEngine(IdGUI id){
        for (EngineGUI enigne : this.listEngine) {
            if(enigne.getId() == id){
                return enigne;
            }
        }
        return null;
    }

    private view.GUI.GUI getGUI(IdGUI id){
        for (GUI gui : this.listGUI) {
            if(gui.getId() == id){
                return gui;
            }
        }
        return null;
    }

    private void quitAll(){
        for (GUI gui : this.listGUI) {
            gui.dispose();
        }
    }
}
