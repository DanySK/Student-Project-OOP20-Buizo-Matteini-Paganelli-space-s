package spacesurvival.view.game.utilities;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.pathImage.Icon;
import spacesurvival.utilities.pathImage.Weapon;
import spacesurvival.view.utilities.JImage;

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

        this.icon = new JImage("shutBullet/45g/ice.png", dimension);
        this.weapon.setIcon(new JImage(Weapon.ICE, dimension).getImageIcon());

        super.add(this.weapon);
        super.add(this.icon);
    }
}
