package view.utilities;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JImage extends JPanel{
    private int width = 0;
    private int height = 0;

    private String path = "";
    private final ImageIcon imageIcon;
    private final JLabel lbImage;

    public JImage(){
        super(new FlowLayout()); {{ setOpaque(false); }}
        this.imageIcon = new ImageIcon();
        this.lbImage = new JLabel(this.imageIcon);
        super.add(this.lbImage);
    }

    public JImage(final String path){
        this();
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
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

    public void setSize(final int width, final int height){
        super.setSize(width, height);
        this.lbImage.setSize(width, height);
        JImage.resizeImage(this.imageIcon, width, height);
        super.repaint();
    }

    public void setSize(final Dimension dimension){
        super.setSize(dimension.width, dimension.height);
    }

    public void setImage(final String path){
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));

        if(this.width != 0){
            JImage.resizeImage(this.imageIcon, this.width, this.height);
        }
        super.repaint();
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
        super.repaint();
    }

    public static void resizeImage(final ImageIcon imageIcon, final int width, final int height){
        Image img = imageIcon.getImage();
        imageIcon.setImage(img.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
    }

    public static void resizeImage(final ImageIcon imageIcon, final Dimension dimension){
        JImage.resizeImage(imageIcon, dimension.width, dimension.height);
    }

    public static Image getImageFromPath(final String path){
        final URL imgURI = ClassLoader.getSystemResource(path);
        return new ImageIcon(imgURI).getImage();
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
}
