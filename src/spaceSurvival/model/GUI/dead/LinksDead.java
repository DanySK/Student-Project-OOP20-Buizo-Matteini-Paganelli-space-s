package spaceSurvival.model.GUI.dead;

import spaceSurvival.utilities.ActionGUI;

public enum LinksDead {
    MENU_BTN("Menu", ActionGUI.ID_MENU),
    QUIT_BTN("Quit", ActionGUI.ID_QUIT);

    private final String name;
    private final ActionGUI actionGUI;

    private LinksDead(final String name, final ActionGUI actionGUI){
        this.name = name;
        this.actionGUI = actionGUI;
    }

    public String getName(){
        return this.name;
    }

    public ActionGUI getAction() {
        return this.actionGUI;
    }

    @Override
    public String toString() {
        return "LinksDead{" +
                "name='" + name + '\'' +
                ", actionGUI=" + actionGUI +  '}';
    }
}
