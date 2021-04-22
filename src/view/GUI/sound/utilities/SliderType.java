package view.GUI.sound.utilities;

import model.GUI.sound.TypeUnitSound;

import javax.swing.*;
import java.util.Objects;

public class SliderType extends JSlider {
    private TypeUnitSound typeSlider;

    public SliderType(){
        super();
    }

    public TypeUnitSound getType() {
        return this.typeSlider;
    }

    public void setType(final TypeUnitSound typeSlider) {
        this.typeSlider = typeSlider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SliderType that = (SliderType) o;
        return typeSlider == that.typeSlider;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeSlider);
    }

    @Override
    public String toString() {
        return "SliderType{" +
                "typeSlider=" + typeSlider +
                '}';
    }
}
