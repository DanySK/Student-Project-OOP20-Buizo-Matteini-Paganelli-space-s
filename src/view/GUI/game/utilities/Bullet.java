package view.GUI.game.utilities;

import utilities.IconPath;
import view.utilities.JImageRate;

import javax.swing.*;
import java.awt.*;

public class Bullet extends JPanel {
    private final JLabel nBullet;
    private final JImageRate icon;

    public Bullet(){
        super(new FlowLayout());
        super.setOpaque(false);

        this.nBullet = new JLabel();
        this.icon = new JImageRate(IconPath.ICON_BULLET, 5);

        this.nBullet.setIcon(new JImageRate(IconPath.ICON_WEAPON, 5).getIcon());

        super.add(this.nBullet);
        super.add(this.icon);
    }
}
