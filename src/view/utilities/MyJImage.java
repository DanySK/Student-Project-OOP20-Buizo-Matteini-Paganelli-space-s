package view.utilities;

import javax.swing.*;
import java.awt.*;

import java.net.URL;

public class MyJImage extends JPanel{
    private Dimension dimensionImg;

    private URL imgURL;
    private ImageIcon imageIcon;
    private JLabel lbImage;

    public MyJImage(final int width, final int height, final String pathImg) {
        super(new FlowLayout());
        this.setOpaque(false);

        this.dimensionImg = new Dimension(width, height);
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.imageIcon = new ImageIcon(this.imgURL);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.lbImage = new JLabel(imageIcon);

        this.add(this.lbImage);
    }

    public MyJImage(final String pathImg) {
        super(new FlowLayout());
        this.setOpaque(false);
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.imageIcon = new ImageIcon(this.imgURL);
        this.lbImage = new JLabel(imageIcon);
        this.add(this.lbImage);
    }

    public void setDimensionImg(final int width, final int height) {
        this.dimensionImg = new Dimension(width, height);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
    }

    public void setDimensionImg(Dimension dimensionImg) {
        this.dimensionImg = dimensionImg;
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public void changeIconAndDimension(final String pathImg, final Dimension dimensionImg){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.dimensionImg.setSize(dimensionImg);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
    }

    public void changeIconAndDimension(final String pathImg, final int width, final int height){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        this.dimensionImg.setSize(width, height);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
    }

    public void changeIcon(final String pathImg){
        this.imgURL = ClassLoader.getSystemResource(pathImg);
        FactoryGUIs.resizeImage(this.dimensionImg.width, this.dimensionImg.height, this.imageIcon);
        this.imageIcon.setImage(new ImageIcon(this.imgURL).getImage());
    }

}
