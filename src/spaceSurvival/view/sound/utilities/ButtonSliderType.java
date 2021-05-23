package spaceSurvival.view.sound.utilities;

import spaceSurvival.model.GUI.sound.TypeUnitSound;

import javax.swing.*;
import java.util.Objects;

public class ButtonSliderType extends JButton {
    private TypeUnitSound typeSlider;

    public ButtonSliderType(){
        super();
    }

    public TypeUnitSound getTypeSlider() {
        return typeSlider;
    }

    public void setTypeSlider(final TypeUnitSound typeSlider) {
        this.typeSlider = typeSlider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ButtonSliderType that = (ButtonSliderType) o;
        return typeSlider == that.typeSlider;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeSlider);
    }

    @Override
    public String toString() {
        return "ButtonSliderType{" +
                "typeSlider=" + typeSlider +
                '}';
    }
}
