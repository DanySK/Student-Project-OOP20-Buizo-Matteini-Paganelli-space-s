package spaceSurvival.view.utilities;

import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Background;

import javax.swing.*;
import java.awt.*;

public class JPanelImage extends JPanel {
    private final ImageIcon icon;

    public JPanelImage(){
        super();
        this.icon = new ImageIcon(Background.TRANSPARENT);
        JPanelImage.setSizeFromScreen(this.icon, Screen.RECTANGLE_FULLSCREEN);
    }

    public void setImage(final String path, final Dimension dimension){
        this.icon.setImage(JImage.getImageFromPath(path));
        JImage.resizeImageIcon(this.icon, dimension);
        super.repaint();
    }

    public void setBounds(final Rectangle screen){
        super.setBounds(screen);
        JPanelImage.setSizeFromScreen(this.icon, screen);
        super.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.icon.getImage(), 0, 0, null);
    }

    public static void setSizeFromScreen(final ImageIcon image, final Rectangle rectangleGUI){
        JImage.resizeImageIcon(image, rectangleGUI.getSize());
    }

}
