package spaceSurvival.view.sound.utilities;

import spaceSurvival.model.GUI.sound.TypeUnitSound;
import java.util.Objects;
import javax.swing.JSlider;

public class SliderType extends JSlider {
    private TypeUnitSound typeSlider;

    public SliderType() {
        super();
    }

    public TypeUnitSound getType() {
        return this.typeSlider;
    }

    public void setType(final TypeUnitSound typeSlider) {
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
        final SliderType that = (SliderType) o;
        return typeSlider == that.typeSlider;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeSlider);
    }

    @Override
    public String toString() {
        return "SliderType{" 
               + "typeSlider=" + typeSlider 
               + '}';
    }
}
