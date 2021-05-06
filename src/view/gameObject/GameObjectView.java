package view.gameObject;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import model.environment.Point2D;
import view.utilities.JImage;

public class GameObjectView extends JComponent {
	
	private static final long serialVersionUID = 1L;
	private Graphics2D graphics;
	private ImageIcon shipImage;
	private AffineTransform transform;
	
	private JImage image;
	
	public GameObjectView() {
	}

	
	public GameObjectView(Graphics2D graphics, ImageIcon img, AffineTransform transform) {
		this.graphics = graphics;
		this.shipImage= img;
		this.transform = transform;
    }
	
	public Graphics2D getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}

	public AffineTransform getTransform() {
		return transform;
	}

	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}

	public void setShipImage(ImageIcon shipImage) {
		this.shipImage = shipImage;
	}
	
    public Image getShipImage() {
        return this.shipImage.getImage();
    }
    
    public void draw(ImageIcon img, AffineTransform transform) {
    	graphics.drawImage(img.getImage(), transform, null);
	}
    
    public void draw(ImageIcon img, Point2D point) {
    	graphics.drawImage(img.getImage(), point.getX(), point.getY(), null);
	}
    
    public void draw(ImageIcon img, int x, int y) {
    	graphics.drawImage(img.getImage(), x, y, null);
	}
    
    public void setPosition(Point2D point) {
    	graphics.drawImage(getShipImage(), point.getX(), point.getY(), null);
	}
    
    public void setPosition(final int x, final int y) {
    	graphics.drawImage(getShipImage(), x, y, null);
	}
    
    public void setSize(final int width, final int height) {
    	JImage.resizeImageIcon(this.shipImage, width, height);
	}

    public void setSize(final Dimension dimension) {
    	JImage.resizeImageIcon(this.shipImage, dimension);
	}
}
