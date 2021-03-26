package controller.GUI;

import controller.GUI.Command.CommandEngine;
import controller.GUI.Command.OFFCommandGUI;
import controller.GUI.Command.ONCommandGUI;
import model.factoryGUI.GUIEngine;
import utilities.IdGUI;
import view.utilities.ButtonID;

import java.util.ArrayList;
import java.util.List;

public class GUI {
    private List<IdGUI> crologia = new ArrayList<>();
    private List<GUIEngine> listEngine;
    private List<view.factoryGUI.GUI> listGUI;
    private CommandEngine onCommandEngine = new ONCommandGUI();
    private CommandEngine offCommandEngine = new OFFCommandGUI();

    public GUI(final List<view.factoryGUI.GUI> listGUI, List<GUIEngine> listEngine){
        this.listEngine = listEngine;
        this.listGUI = listGUI;
        this.crologia.add(IdGUI.ID_MENU);
        this.linksAll();
    }

    private void linksAll(){

        for (view.factoryGUI.GUI gui : this.listGUI) {
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

    private view.factoryGUI.GUI getGUI(IdGUI id){
        for (view.factoryGUI.GUI gui : this.listGUI) {
            if(gui.getId() == id){
                return gui;
            }
        }
        return null;
    }

    private void quitAll(){
        for (view.factoryGUI.GUI gui : this.listGUI) {
            gui.dispose();
        }
    }
}
