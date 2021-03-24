package controller.GUI;

import controller.GUI.Command.CommandEngine;
import controller.GUI.Command.OFFCommandEngine;
import controller.GUI.Command.ONCommandEngine;
import model.factoryGUI.GUIEngine;
import utilities.IdGUI;
import view.factoryGUI.GUI;
import view.utilities.ButtonID;

import java.util.ArrayList;
import java.util.List;

public class ControllerGUI {
    private List<IdGUI> crologia = new ArrayList<>();
    private List<GUIEngine> listEngine;
    private List<GUI> listGUI;
    private CommandEngine onCommandEngine = new ONCommandEngine();
    private CommandEngine offCommandEngine = new OFFCommandEngine();

    public ControllerGUI(final List<GUI> listGUI, List<GUIEngine> listEngine){
        this.listEngine = listEngine;
        this.listGUI = listGUI;
        this.crologia.add(IdGUI.ID_MENU);
        this.linksAll();
    }

    private void linksAll(){

        for (GUI gui : this.listGUI) {
            for (ButtonID btn : gui.getLinksButtons()) {
                btn.addActionListener(e -> {
                    System.out.println("Premuto in: " + btn.getCurrentGUIID() + " Vado in: " + btn.getCommandIdGUI());

                    switch (btn.getCommandIdGUI()) {
                        case ID_QUIT: this.quitAll(); break;
                        case ID_BACK:
                            this.offCommandEngine.execute(this.getEngine(this.lastCrono())).execute(this.getGUI(this.lastCrono()));
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            this.onCommandEngine.execute(this.getEngine(this.penultimateCrono())).execute(this.getGUI(this.penultimateCrono()));
                            this.crologia.remove(this.lastCrono()); break;
                        default:
                            this.crologia.add(btn.getCommandIdGUI());
                            this.onCommandEngine.execute(this.getEngine(this.lastCrono())).execute(this.getGUI(this.lastCrono()));
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            this.offCommandEngine.execute(this.getEngine(this.penultimateCrono())).execute(this.getGUI(this.penultimateCrono())); break;
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

    private GUIEngine getEngine(IdGUI id){
        for (GUIEngine enigne : this.listEngine) {
            if(enigne.getId() == id){
                return enigne;
            }
        }
        return null;
    }

    private GUI getGUI(IdGUI id){
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
