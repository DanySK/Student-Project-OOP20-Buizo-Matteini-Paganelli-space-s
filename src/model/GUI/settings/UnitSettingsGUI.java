package model.GUI.settings;

public enum UnitSettingsGUI {
    UNIT_SKIN("Skin"),
    UNIT_DIFFICULT("Difficult");

    private String title;

    private UnitSettingsGUI(final String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
