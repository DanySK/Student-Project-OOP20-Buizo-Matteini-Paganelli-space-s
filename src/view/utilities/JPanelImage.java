package view.utilities;

import utilities.DimensionScreen;

import javax.swing.*;
import java.awt.*;

public class JPanelImage extends JPanel {
    private final ImageIcon icon;

    public JPanelImage(){
        super();
        this.icon = new ImageIcon();
    }

    public JPanelImage(final String path){
        this();
        this.icon.setImage(JImage.getImageFromPath(path));
        JPanelImage.setSizeFromScreen(this.icon, DimensionScreen.RECTANGLE_FULLSCREEN);
    }

    public JPanelImage(final String path, final Rectangle rectangleGUI){
        this(path);
        JPanelImage.setSizeFromScreen(this.icon, rectangleGUI);
    }

    public void setImage(final String path){
        final Dimension dimension = new Dimension(this.icon.getIconWidth(), this.icon.getIconHeight());
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
