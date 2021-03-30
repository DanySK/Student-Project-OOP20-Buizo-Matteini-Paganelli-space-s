package model.GUI.help;

public enum HelpButtonsName {
    BUTTON_BACK("Back");

    private String name;

    private HelpButtonsName(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
