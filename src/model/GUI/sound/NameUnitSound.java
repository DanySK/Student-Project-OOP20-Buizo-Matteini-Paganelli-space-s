package model.GUI.sound;

public enum NameUnitSound {
    SLIDER_BACKGROUND("Main"),
    SLIDER_EFFECT("Effect");

    private final String name;

    private NameUnitSound(final String name){
        this.name = name;
    }

    public String getNameUnitSound(){
        return this.name;
    }
}
