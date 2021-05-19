package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.model.image.EngineImage;
import spaceSurvival.utilities.DesignSpace;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.view.utilities.JImage;

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
