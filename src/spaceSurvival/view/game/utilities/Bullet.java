package spaceSurvival.view.game.utilities;

import spaceSurvival.model.EngineImage;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.pathImage.Weapon;
import spaceSurvival.view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class Bullet extends JPanel {
    private final JLabel weapon;
    private final JImage icon;

    public Bullet(){
        super(new FlowLayout());
        super.setOpaque(false);

        this.weapon = new JLabel();
        final Dimension dimension = EngineImage.getSizeImageFromScale(
                Icon.HEART, ScaleOf.ICON_FULL, Screen.WIDTH_FULL_SCREEN);

        this.icon = new JImage(Icon.BULLET, dimension);
        this.weapon.setIcon(new JImage(Weapon.ICE, dimension).getImageIcon());

        super.add(this.weapon);
        super.add(this.icon);
    }
}
