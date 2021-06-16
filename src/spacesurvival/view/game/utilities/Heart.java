package spacesurvival.view.game.utilities;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.path.Icon;
import spacesurvival.view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class Heart extends JPanel {
    private final JImage iconHeart;
    private final JLabel nHeart;

    public Heart(){
        super(new FlowLayout());
        super.setOpaque(false);
        final Dimension dimension = EngineImage.getSizeImageFromScale(
                Icon.HEART, ScaleOf.ICON_FULL, Screen.WIDTH_FULL_SCREEN);

        this.iconHeart = new JImage(Icon.HEART, dimension);
        this.nHeart = new JLabel("x3");
        this.add(this.iconHeart);
        this.add(this.nHeart);
    }

    public void setFontAll(final Font font){
        this.nHeart.setFont(font);
    }

    public void setForegroundAll(final Color color){
        this.nHeart.setForeground(color);
    }

    public void setnHeart(final int n){
        this.nHeart.setText("x" + n);
    }

    public void setnHeart(final String n){
        this.nHeart.setText("x" + n);
    }

}
