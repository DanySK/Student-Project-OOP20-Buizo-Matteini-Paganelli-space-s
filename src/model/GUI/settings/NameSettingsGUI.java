package model.GUI.settings;

public enum NameSettingsGUI {
    TITLE_UNIT_SKIN("Skin"),
    TITLE_UNIT_DIFFICULT("Difficult");

    private String title;

    private NameSettingsGUI(final String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
