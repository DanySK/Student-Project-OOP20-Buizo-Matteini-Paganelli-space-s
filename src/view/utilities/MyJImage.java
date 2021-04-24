package view.utilities;

import utilities.DesignSpace;

import javax.swing.*;
import java.awt.*;

import java.net.URL;

public class MyJImage extends JPanel{
    private Dimension dimensionImg = new Dimension();

    private URL imgURL;
    private ImageIcon imageIcon = new ImageIcon();
    private final JLabel lbImage = new JLabel();

    public MyJImage(final int width, final int height, final String pathImg) {
        super(new FlowLayout());
        this.setOpaque(false);

        this.dimensionImg.setSize(width, height);
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.lbImage.setIcon(this.imageIcon);

        this.add(this.lbImage);
    }

    public MyJImage(final String pathImg) {
        super(new FlowLayout());
        this.setOpaque(false);
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
        this.lbImage.setIcon(this.imageIcon);
        this.add(this.lbImage);
    }

    public MyJImage(final int width, final int height) {
        super(new FlowLayout());
        this.setOpaque(false);
        this.dimensionImg.setSize(width, height);
        this.lbImage.setIcon(this.imageIcon);
        this.add(this.lbImage);
    }

    public MyJImage(){
        super(new FlowLayout());
        this.setOpaque(false);
        this.lbImage.setIcon(this.imageIcon);
        this.add(this.lbImage);
    }

    public void setDimensionImg(final int width, final int height) {
        this.dimensionImg.setSize(width, height);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.lbImage.repaint();
    }

    public void setDimensionImg(final Dimension dimensionImg) {
        this.dimensionImg.setSize(dimensionImg.width, dimensionImg.height);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.lbImage.repaint();
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public void changeIconAndDimension(final String pathImg, final Dimension dimensionImg){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.dimensionImg.setSize(dimensionImg);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
    }

    public void setImageIcon(final String pathImg, final int width, final int height){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.dimensionImg.setSize(width, height);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
    }

    public void setIconImage(final String pathImg){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
    }

    public void setBorder(final int thickness){
        super.setBorder(BorderFactory.createLineBorder(DesignSpace.color4, 5));
    }


}
