package view.GUI.game.utilities;

import model.image.EngineImage;
import utilities.DesignSpace;
import utilities.DimensionScreen;
import utilities.IconPath;
import view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class Heart extends JPanel {
    private final JImage iconHeart;
    private final JLabel nHeart;

    public Heart(){
        super(new FlowLayout());
        super.setOpaque(false);
        final Dimension dimension = EngineImage.getSizeFromRate(
                IconPath.ICON_HEART, 30, DimensionScreen.WIDTH_FULL_SCREEN);

        this.iconHeart = new JImage(IconPath.ICON_HEART, dimension);
        this.nHeart = new JLabel("x3");
        this.add(this.iconHeart);
        this.add(this.nHeart);
        this.nHeart.setForeground(DesignSpace.color4);
        this.nHeart.setFont(DesignSpace.getFontForGame(35));
    }


}
