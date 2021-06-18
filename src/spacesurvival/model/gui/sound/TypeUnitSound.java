package spacesurvival.model.gui.sound;

public enum TypeUnitSound {
    SLIDER_BACKGROUND("Main"),
    SLIDER_EFFECT("Effect");

    private final String name;

    private TypeUnitSound(final String name) {
        this.name = name;
    }

    public String getNameUnitSound() {
        return this.name;
    }
}
