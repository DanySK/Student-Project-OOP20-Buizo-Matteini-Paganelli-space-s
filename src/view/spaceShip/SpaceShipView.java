package view.spaceShip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import model.environment.Point2D;
import view.utilities.MyJImage;

public class SpaceShipView {

    private final JFrame frame = new JFrame();
    private MyJImage shipImage;
    
    public SpaceShipView(final String shipImagePath, Point2D imagePosition) {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 600);
        
        JPanel panel = new JPanel();
        this.frame.setContentPane(panel);
        
        
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
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        panel.add(this.shipImage);
        
        final JButton button = new JButton("prova");
        button.addActionListener(event -> {
            this.shipImage.setLocation(this.shipImage.getX() + 10, this.shipImage.getY() + 10);
        });
        panel.add(button);
    }
    
    public void show() {
        this.frame.setVisible(true);
    }
    
    public MyJImage getShipImage() {
        return this.shipImage;
    }
}
