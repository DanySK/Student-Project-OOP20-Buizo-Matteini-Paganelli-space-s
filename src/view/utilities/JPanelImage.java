package view.utilities;

import utilities.DimensionScreen;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JPanelImage extends JPanel {
    private URL imgURL;
    private final ImageIcon icon;

    public JPanelImage(){
        super();
        this.icon = new ImageIcon();
    }

    public JPanelImage(final String pathImg){
        super();
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.icon = new ImageIcon(this.imgURL);
        FactoryGUIs.sizeImageFromScreen(DimensionScreen.RECTANGLE_FULLSCREEN, this.icon);
    }

    public JPanelImage(final Rectangle rectangleGUI, final String pathImg){
        super();
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.icon = new ImageIcon(this.imgURL);
        FactoryGUIs.sizeImageFromScreen(rectangleGUI, this.icon);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.icon.getImage(), 0, 0, null);
    }

    public void setImage(final String pathImg){
        final Dimension dimension = new Dimension(this.icon.getIconWidth(), this.icon.getIconHeight());
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.icon.setImage(new ImageIcon(this.imgURL).getImage());
        FactoryGUIs.resizeImage(dimension, this.icon);
        super.repaint();
    }

    public void setBounds(final Rectangle screen){
        super.setBounds(screen);
        FactoryGUIs.sizeImageFromScreen(screen, this.icon);
        super.repaint();
    }

    public void setProvaDimension(final Dimension dimension){
        FactoryGUIs.resizeImage(dimension, this.icon);
        super.setSize(dimension);
    }

}
