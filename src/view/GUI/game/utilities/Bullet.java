package view.GUI.game.utilities;

import model.image.EngineImage;
import utilities.DimensionScreen;
import utilities.IconPath;
import view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class Bullet extends JPanel {
    private final JLabel nBullet;
    private final JImage icon;

    public Bullet(){
        super(new FlowLayout());
        super.setOpaque(false);

        this.nBullet = new JLabel();
        final Dimension dimension = EngineImage.getSizeImageFromScale(
                IconPath.ICON_HEART, 30, DimensionScreen.WIDTH_FULL_SCREEN);

        this.icon = new JImage(IconPath.ICON_BULLET, dimension);
        this.nBullet.setIcon(new JImage(IconPath.ICON_WEAPON, dimension).getImageIcon());

        super.add(this.nBullet);
        super.add(this.icon);
    }
}
