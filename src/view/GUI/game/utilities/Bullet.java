package view.GUI.game.utilities;

import model.image.EngineImage;
import utilities.dimension.Screen;
import utilities.pathImage.Icon;
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
                Icon.HEART, 30, Screen.WIDTH_FULL_SCREEN);

        this.icon = new JImage(Icon.BULLET, dimension);
        this.nBullet.setIcon(new JImage(Icon.WEAPON, dimension).getImageIcon());

        super.add(this.nBullet);
        super.add(this.icon);
    }
}
