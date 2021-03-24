package model.factoryGUI.settingsGUI;

public enum NameSettigsGUI {
    TITLE_PANEL_SKIN("Skin"),
    TITLE_PANEL_DIFFICULT("Difficult"),
    TITLE_PANEL_SOUND("Sound"),
    BUTTON_BACK("Back");

    private String title;

    private NameSettigsGUI(final String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
