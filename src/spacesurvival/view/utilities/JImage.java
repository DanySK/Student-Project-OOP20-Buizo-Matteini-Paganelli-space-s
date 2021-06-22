package spacesurvival.view.utilities;

import spacesurvival.model.EngineImage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * 
 * @author buizo
 *
 */
public class JImage extends JComponent {
    private static final long serialVersionUID = -2971663994387728066L;
    private int width, height;
    private String path = "";

    private final ImageIcon imageIcon;
    private JLabel lbImage;

    public JImage(){
        super();
        super.setLayout(new BorderLayout());
        this.imageIcon = new ImageIcon();
        this.lbImage = new JLabel(this.imageIcon);
        super.add(this.lbImage, BorderLayout.CENTER);
    }

    public JImage(final String path) {
        this();
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
        this.setSize(EngineImage.getSizeFromImage(path));
    }

    public JImage(final String path, final int width, final int height) {
        this(path);
        this.setSize(width, height);
    }

    public JImage(final String path, final Dimension dimension) {
        this(path, dimension.width, dimension.height);
    }



    public String getPath() {
        return this.path;
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    @Override
    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public Image getImage() {
        return this.imageIcon.getImage();
    }


    @Override
    public void setSize(final int width, final int height) {
        super.setSize(width, height);
        this.lbImage.setSize(width, height);
        this.width = width;
        this.height = height;
        JImage.resizeImageIcon(this.imageIcon, width, height);
        this.repaint();
    }

    @Override
    public void setSize(final Dimension dimension) {
        this.setSize(dimension.width, dimension.height);
    }

    public void setImage(final String path) {
        this.path = path;
        this.imageIcon.setImage(JImage.getImageFromPath(path));
        if (this.width != 0) {
            this.setSize(this.width, this.height);
        }
        this.repaint();
    }

    @Override
    public void setBounds(final Rectangle rectangle) {
        super.setBounds(rectangle);
        this.lbImage.setBounds(rectangle);
        this.setSize(rectangle.getSize());
    }

    public void setScaleOfRespect(final int scaleOf, final int respectTo) {
        final Dimension dimension = EngineImage.getSizeImageFromScale(this.path, scaleOf, respectTo);
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

    public static void resizeImageIcon(final ImageIcon imageIcon, final int width, final int height) {
        final Image img = imageIcon.getImage();
        imageIcon.setImage(img.getScaledInstance(width, height, Image.SCALE_REPLICATE));
    }

    public static void resizeImageIcon(final ImageIcon imageIcon, final Dimension dimension) {
        JImage.resizeImageIcon(imageIcon, dimension.width, dimension.height);
    }

    public static Image getImageFromPath(final String path) {
        final URL imgURI = ClassLoader.getSystemResource(path);
        return new ImageIcon(imgURI).getImage();
    }
}
