package view.spaceShip;

import java.awt.Color;

import javax.swing.*;

import model.environment.Point2D;
import view.utilities.MyJImage;

public class SpaceShipView extends JPanel{
    private MyJImage shipImage;
    
    public SpaceShipView(final String shipImagePath, Point2D imagePosition) {
        
        this.shipImage = new MyJImage(shipImagePath);
        
        int shipWidth = this.shipImage.getImageIcon().getIconHeight();
        int shipHeight = this.shipImage.getImageIcon().getIconHeight();
        
        this.shipImage.setDimensionImg(shipWidth / 3, shipHeight / 3);
        //this.shipImage.setLocation(0, 0);//imagePosition.getY());
        System.out.println(imagePosition.toString());
        this.shipImage.setBounds(imagePosition.getX(), imagePosition.getY(), shipWidth, shipHeight);
        //this.shipImage.setSize(shipWidth, shipHeight);
        this.shipImage.setOpaque(true);
        this.shipImage.setBackground(Color.BLUE);
        super.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        super.add(this.shipImage);
        
        final JButton button = new JButton("prova");
        button.addActionListener(event -> {
            super.setLocation(super.getX() + 10, super.getY() + 10);
        });
        super.add(button);
    }
    
    public MyJImage getShipImage() {
        return this.shipImage;
    }
}
