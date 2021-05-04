package view.spaceShip;

import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import model.GUI.settings.SkinSpaceShip;
import model.environment.Point2D;
import utilities.IconPath;
import view.utilities.JImage;

<<<<<<< HEAD
import javax.swing.*;

public class SpaceShipView extends JComponent {
	private static final long serialVersionUID = 1L;

	public SpaceShipView() {
        super();
        
        super.setOpaque(true);
        super.setBackground(Color.BLUE);
        super.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        super.setBounds(200, 200, 200, 200);
        super.setLocation(super.getX() + 10, super.getY() + 10);
    }


    @Override
	public void paintComponent(final Graphics g){
//		super.paintComponent(g);
		final Graphics2D g2d = (Graphics2D) g;

		Image img = JImage.getImageFromPath(SkinSpaceShip.MALA.getPath());
		g2d.drawImage(img, 50, 50, null);



		System.out.println("sssss" + img);


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
