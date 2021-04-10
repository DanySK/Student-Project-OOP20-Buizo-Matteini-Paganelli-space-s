package model.GUI.sound;

import java.util.List;

public enum NameSoundGUI {
    SLIDER_BACKGROUND("Main"),
    SLIDER_EFFECT("Effect"),
    BACK_BUTTON("Back");

    private final String name;

    private NameSoundGUI(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static List<String> getNameSlider(){
        return List.of(SLIDER_BACKGROUND.getName(), SLIDER_EFFECT.getName());
    }
}
