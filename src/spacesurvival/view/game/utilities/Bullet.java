package spacesurvival.view.game.utilities;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.BulletHUD;
import spacesurvival.utilities.path.Icon;
import spacesurvival.utilities.path.Weapon;
import spacesurvival.view.utilities.JImage;


public class Bullet extends JPanel {
    private static final long serialVersionUID = 8962529427424782971L;
    private final JImage weapon;
    private final JImage icon;

    public Bullet() {
        super(new FlowLayout());
        super.setOpaque(false);

        final Dimension dimension = EngineImage.getSizeImageFromScale(
                Icon.HEART, ScaleOf.ICON_FULL, Screen.WIDTH_FULL_SCREEN);

        this.weapon = new JImage(Weapon.NORMAL, dimension);
        this.icon = new JImage(BulletHUD.NORMAL, dimension);

        super.add(this.weapon);
        super.add(this.icon);
    }

    public void setWeapon(final String weapon) {
        this.weapon.setImage(weapon);
    }

    public void setBullet(final String bullet) {
        this.icon.setImage(bullet);
    }
}
