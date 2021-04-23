package view.spaceShip;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import model.environment.Point2D;
import view.utilities.MyJImage;

public class SpaceShipView extends MyJImage {
	private static final long serialVersionUID = 1L;

	public SpaceShipView() {
        super();
        
//        super.setOpaque(true);
//        super.setBackground(Color.BLUE);
//        super.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        super.setLocation(super.getX() + 10, super.getY() + 10);
    }
    
    public MyJImage getShipImage() {
        return this;
    }
    
    public void setPosition(Point2D point) {
		this.setLocation(point.getX(), point.getY());
	}
    
    public void setDimension(final Dimension dimension) {
		super.setDimensionImg(dimension);
	}
}
