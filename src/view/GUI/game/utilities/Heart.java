package view.GUI.game.utilities;

import utilities.DesignSpace;
import utilities.IconPath;
import view.utilities.JImageRate;

import javax.swing.*;
import java.awt.*;

public class Heart extends JPanel {
    private final JImageRate iconHeart;
    private final JLabel nHeart;

    public Heart(){
        super(new FlowLayout());
        super.setOpaque(false);
        this.iconHeart = new JImageRate(IconPath.ICON_HEART, 6);
        this.nHeart = new JLabel("x3");
        this.add(this.iconHeart);
        this.add(this.nHeart);
        this.nHeart.setForeground(DesignSpace.color4);
        this.nHeart.setFont(DesignSpace.getFontForGame(35));
    }


}
