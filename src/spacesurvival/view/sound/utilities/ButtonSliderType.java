package spacesurvival.view.sound.utilities;

import spacesurvival.model.gui.sound.TypeUnitSound;
import java.util.Objects;

import javax.swing.JButton;

public class ButtonSliderType extends JButton {
    private TypeUnitSound typeSlider;

    public ButtonSliderType() {
        super();
    }

    public TypeUnitSound getTypeSlider() {
        return typeSlider;
    }

    public void setTypeSlider(final TypeUnitSound typeSlider) {
        this.typeSlider = typeSlider;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ButtonSliderType that = (ButtonSliderType) o;
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
