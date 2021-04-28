package view.utilities;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JImage extends JComponent{
    private int width, height;
    private String path = "";

    private final ImageIcon imageIcon;
    private final JLabel lbImage;

    public JImage(){
        super(); {{ setOpaque(false);}}
        super.setLayout(new BorderLayout());
        this.imageIcon = new ImageIcon();
        this.lbImage = new JLabel(this.imageIcon);

        super.add(this.lbImage, BorderLayout.CENTER );
    }

    public JImage(final String path){
        this();
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
    }

    public JImage(final String path, final int w, final int h){
        this(path);
        this.width = w;
        this.height = h;
        this.setSize(w, h);
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

    public void setSize(final int w, final int h){
        super.setSize(w, h);
        this.lbImage.setSize(w, h);
        this.width = w;
        this.height = h;
        JImage.resizeImageIcon(this.imageIcon, w, h);
        System.out.println(this.width + "setsize" + this.height);
    }

    public void setSize(final Dimension dimension){
        this.setSize(dimension.width, dimension.height);
    }

    public void setImage(final String path){
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
        if(this.width != 0)
        this.setSize(this.width, this.height);
        //System.out.println(this.width + "setImage" + this.height);
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
