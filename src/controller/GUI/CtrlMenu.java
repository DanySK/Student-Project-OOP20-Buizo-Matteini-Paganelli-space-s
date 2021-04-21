package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.menu.EngineMenu;
import view.GUI.GUI;
import view.GUI.menu.GUIMenu;

public class CtrlMenu implements ControllerGUI {
    private GUIMenu GUIMenu;
    private EngineMenu menuEngine;

    public CtrlMenu(final GUIMenu menuGUI, final EngineMenu menuEngine){
        this.GUIMenu = menuGUI;
        this.menuEngine = menuEngine;
        this.initMenu();
    }

    private void initMenu(){
        this.GUIMenu.setId(this.menuEngine.getId());
        this.GUIMenu.setTitleGUI(this.menuEngine.getTitleGUI());
        this.GUIMenu.setNameButtons(this.menuEngine.getListName());
        this.GUIMenu.setIdButtons(this.menuEngine.getLinks());
        this.GUIMenu.setVisible(this.menuEngine.isVisible());
    }

    public GUI getGUI() {
        return this.GUIMenu;
    }

    public EngineGUI getEngine() {
        return this.menuEngine;
    }
}
