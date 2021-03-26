package view.spaceShip;

import java.awt.Color;

import javax.swing.*;

import model.MyJImage.JImageRateEngine;
import model.environment.Point2D;
import view.utilities.JImageRate;

public class SpaceShipView {

    private final JFrame frame = new JFrame();
    private JImageRate shipImage;
    
    public SpaceShipView(final JImageRateEngine imageEngine, final Point2D imagePosition) {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 600);
        
        JPanel panel = new JPanel(null);
        this.frame.setContentPane(panel);
        
        
        this.shipImage = new JImageRate(imageEngine.getPathImg(), imageEngine.getRate());
        //this.shipImage.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        
        int shipWidth = this.shipImage.getIcon().getIconHeight();
        int shipHeight = this.shipImage.getIcon().getIconHeight();
        
        this.shipImage.setBounds(imagePosition.getX(), imagePosition.getY(), shipWidth, shipHeight);

        this.shipImage.setOpaque(true);
        this.shipImage.setBackground(Color.BLUE);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        panel.add(this.shipImage);
        
        final JButton button = new JButton("prova");
        button.addActionListener(event -> {
            this.shipImage.setLocation(this.shipImage.getX() + 10, this.shipImage.getY() + 10);
        });
        button.setBounds(10, 10, 50, 30);

        panel.add(button);
    }
    
    public void show() {
        this.frame.setVisible(true);
    }
    
    public JImageRate getShipImage() {
        return this.shipImage;
    }
}
