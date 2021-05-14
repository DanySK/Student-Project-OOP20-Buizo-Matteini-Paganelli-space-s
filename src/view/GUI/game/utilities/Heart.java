package view.GUI.game.utilities;

import model.image.EngineImage;
import utilities.DesignSpace;
import utilities.dimension.Screen;
import utilities.pathImage.Icon;
import view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class Heart extends JPanel {
    private final JImage iconHeart;
    private final JLabel nHeart;

    public Heart(){
        super(new FlowLayout());
        super.setOpaque(false);
        final Dimension dimension = EngineImage.getSizeImageFromScale(
                Icon.HEART, 30, Screen.WIDTH_FULL_SCREEN);

        this.iconHeart = new JImage(Icon.HEART, dimension);
        this.nHeart = new JLabel("x3");
        this.add(this.iconHeart);
        this.add(this.nHeart);
        this.nHeart.setForeground(DesignSpace.color4);
        this.nHeart.setFont(DesignSpace.getFontForGame(35));
    }


}
