package view.spaceShip;

import java.awt.*;

import model.environment.Point2D;
import view.utilities.JImage;

public class SpaceShipView extends JImage {
	private static final long serialVersionUID = 1L;

	public SpaceShipView() {
        super();
        
//        super.setOpaque(true);
//        super.setBackground(Color.BLUE);
//        super.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        super.setLocation(super.getX() + 10, super.getY() + 10);
    }
    
    public JImage getShipImage() {
        return this;
    }
    
    public void setPosition(Point2D point) {
		this.setLocation(point.getX(), point.getY());
	}
    
    public void setSize(final Dimension dimension) {
		super.setSize(dimension);
	}

}
