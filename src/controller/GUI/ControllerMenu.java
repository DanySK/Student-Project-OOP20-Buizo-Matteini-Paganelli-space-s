package controller.GUI;

import model.factoryGUI.menuGUI.MenuEngine;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.MenuGUI;

public class ControllerMenu {
    private MenuGUI menuGUI;
    private MenuEngine menuEngine;

    public ControllerMenu(final MenuGUI menuGUI, final MenuEngine menuEngine){
        this.menuGUI = menuGUI;
        this.menuEngine = menuEngine;
        this.initMenu();
    }

    private void initMenu(){
        this.menuGUI.setId(this.menuEngine.getId());
        this.menuGUI.setTitleGUI(this.menuEngine.getTitleGUI());
        this.menuGUI.setNameButtons(this.menuEngine.getListName());
        this.menuGUI.setIDButtons(this.menuEngine.getLinks());
        this.menuGUI.setVisible(this.menuEngine.getState());

    }

}
