package controller.GUI.utilities;

import controller.GUI.Command.CmdEngine;
import controller.GUI.Command.CmdOFF;
import controller.GUI.Command.CmdON;
import model.GUI.EngineGUI;
import utilities.IdGUI;
import view.GUI.GUI;

import java.util.ArrayList;
import java.util.List;

public class ListGUI{
    private List<IdGUI> listGUI;
    private CmdEngine onCmdEngine;
    private CmdEngine offCmdEngine;

    public ListGUI(){
        super();
        this.listGUI = new ArrayList<>();
        this.onCmdEngine = new CmdOFF();
        this.offCmdEngine = new CmdOFF();

    }

    public void addGUI(final IdGUI idGUI){
        if(this.listGUI.size() == 0 || !this.getLastElement().equals(idGUI)){
            this.listGUI.add(idGUI);
        }
    }

    public void removeGUI(final List<GUI> guiList, final List<EngineGUI> guiEngine){
        int topDown = this.listGUI.size() - 1;
        while (topDown > 0 && this.listGUI.get(topDown) != utilities.IdGUI.ID_MENU) {
            this.listGUI.remove(topDown--);
        }
    }

    public IdGUI get(final int ind){
        return this.listGUI.get(ind);
    }

    public IdGUI getLastElement(){
        return this.listGUI.get(this.listGUI.size() - 1);
    }

    public IdGUI penultimateElement(){
        return this.listGUI.get(this.listGUI.size() - 2);
    }




    private EngineGUI getEngine(final List<EngineGUI> engineGUIS, final IdGUI id){
        for (EngineGUI engine : engineGUIS) {
            if(engine.getId().equals(id)){
                return engine;
            }
        }
        return null;
    }

    private view.GUI.GUI getGUI(final List<GUI> guis, final IdGUI id){
        for (GUI gui : guis) {
            if(gui.getId().equals(id)){
                return gui;
            }
        }
        return null;
    }
}
