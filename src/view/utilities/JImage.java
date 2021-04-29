package view.utilities;

import model.image.EngineImage;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JImage extends JComponent{
    private int width, height;
    private String path = "";

    private final ImageIcon imageIcon;
    private final JLabel lbImage;

    public JImage(){
        super(); {{ setOpaque(false); setLayout(new BorderLayout()); }}
        this.imageIcon = new ImageIcon();
        this.lbImage = new JLabel(this.imageIcon);
        super.add(this.lbImage, BorderLayout.CENTER );
    }

    public JImage(final String path){
        this();
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
        this.setSize(EngineImage.getSizeFromImage(path));
    }

    public JImage(final String path, final int width, final int height){
        this(path);
        this.setSize(width, height);
    }

    public JImage(final String path, final Dimension dimension){
        this(path, dimension.width, dimension.height);
    }


    public String getPath() {
        return this.path;
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public Dimension getSize(){
        return new Dimension(this.width, this.height);
    }


    public void setSize(final int width, final int height){
        super.setSize(width, height);
        this.lbImage.setSize(width, height);
        this.width = width;
        this.height = height;
        JImage.resizeImageIcon(this.imageIcon, width, height);
    }

    public void setSize(final Dimension dimension){
        this.setSize(dimension.width, dimension.height);
    }

    public void setImage(final String path){
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
        if(this.width != 0)
        this.setSize(this.width, this.height);
    }

    public void setImageAndSize(final String path, final int width, final int height){
        this.setSize(width, height);
        this.setImage(path);
    }

    public void setImageAndSize(final String path, final Dimension dimension){
        this.setSize(dimension.width, dimension.height);
        this.setImage(path);
    }

    public void setBounds(final Rectangle rectangle){
        super.setBounds(rectangle);
        this.lbImage.setBounds(rectangle);
        this.setSize(rectangle.getSize());
    }

    public void setScaleOfRespect(final int scaleOf, final int respectTo){
        final Dimension dimension = EngineImage.getSizeImageFromRate(this.path, scaleOf, respectTo);
        this.setSize(dimension);
    }

    @Override
    public String toString() {
        return "JImage{" +
                "width=" + width +
                ", height=" + height +
                ", path='" + path + '\'' +
                ", imageIcon=" + imageIcon +
                ", lbImage=" + lbImage +
                '}';
    }

    public static void resizeImageIcon(final ImageIcon imageIcon, final int width, final int height){
        Image img = imageIcon.getImage();
        imageIcon.setImage(img.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
    }

    public static void resizeImageIcon(final ImageIcon imageIcon, final Dimension dimension){
        JImage.resizeImageIcon(imageIcon, dimension.width, dimension.height);
    }

    public static Image getImageFromPath(final String path){
        final URL imgURI = ClassLoader.getSystemResource(path);
        return new ImageIcon(imgURI).getImage();
    }
}
