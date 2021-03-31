package model.GUI.help;

public enum HelpNameButtons {
    BUTTON_BACK("Back");

    private String name;

    private HelpNameButtons(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
