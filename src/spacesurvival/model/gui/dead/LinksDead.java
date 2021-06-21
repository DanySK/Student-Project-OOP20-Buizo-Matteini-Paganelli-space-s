package spacesurvival.model.gui.dead;

import spacesurvival.utilities.LinkActionGUI;

public enum LinksDead {
    MENU_BTN("Menu", LinkActionGUI.ID_MENU),
    QUIT_BTN("Quit", LinkActionGUI.ID_QUIT);

    private final String name;
    private final LinkActionGUI linkActionGUI;

    private LinksDead(final String name, final LinkActionGUI linkActionGUI){
        this.name = name;
        this.linkActionGUI = linkActionGUI;
    }

    public String getName(){
        return this.name;
    }

    public LinkActionGUI getAction() {
        return this.linkActionGUI;
    }

    @Override
    public String toString() {
        return "LinksDead{" +
                "name='" + name + '\'' +
                ", actionGUI=" + linkActionGUI +  '}';
    }
}
