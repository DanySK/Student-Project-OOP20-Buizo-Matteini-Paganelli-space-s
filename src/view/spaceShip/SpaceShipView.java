package view.spaceShip;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import model.environment.Point2D;
import view.utilities.MyJImage;

public class SpaceShipView extends MyJImage {

	private static final long serialVersionUID = 1L;

	public SpaceShipView(final String shipImagePath, Point2D imagePosition) { 
        super();
        
//        super.setOpaque(true);
//        super.setBackground(Color.BLUE);
//        super.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        super.addKeyListener(new KeyListener() {
        	public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				System.out.println("premuto");
			}
		});

        
        super.setLocation(super.getX() + 10, super.getY() + 10);
    }
    
    public MyJImage getShipImage() {
        return this;
    }
    
    public void setPosition(Point2D point) {
		this.setLocation(point.getX(), point.getY());
	}
    
    public void setDimension(Dimension dimension) {
		this.setDimension(dimension);
	}
}
