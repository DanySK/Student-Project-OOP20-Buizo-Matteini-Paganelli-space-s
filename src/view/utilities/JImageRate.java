package view.utilities;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JImageRate extends JPanel {
    private URL pathImg;
    private int rate = 0;
    private ImageIcon icon = new ImageIcon();
    private JLabel lbImage = new JLabel();

    public JImageRate(){
        super(new FlowLayout());
        this.setOpaque(false);
        this.lbImage.setIcon(this.icon);
        this.add(this.lbImage);
    }

    public JImageRate(final String pathImg){
        this();
        this.pathImg = ClassLoader.getSystemResource(pathImg);
        this.icon.setImage(new ImageIcon(this.pathImg).getImage());
    }

    public JImageRate(final String path, final int rate){
       this(path);
       this.rate = rate;
       FactoryGUIs.rateImage(this.rate, this.icon);
    }

    public int getRate() {
        return this.rate;
    }

    public ImageIcon getIcon() {
        return this.icon;
    }

    public Dimension getDimension(){
        return new Dimension(this.icon.getIconWidth(), this.icon.getIconHeight());
    }

    public void setRate(int rate) {
        this.rate = rate;
        FactoryGUIs.rateImage(this.rate, this.icon);
        this.lbImage.repaint();
    }

    public void setIcon(final String pathImg) {
        this.pathImg = ClassLoader.getSystemResource(pathImg);
        this.icon.setImage(new ImageIcon(this.pathImg).getImage());
        this.lbImage.repaint();
    }

    public void setRateIcon(final String pathImg, final int rate){
        this.setIcon(pathImg);
        this.setRate(rate);
    }




}
