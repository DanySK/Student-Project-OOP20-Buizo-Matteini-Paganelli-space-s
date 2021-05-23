package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.view.utilities.JImage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;

public class PanelGame extends JPanel {
    private final Map<GameObject, AffineTransform> gameObject;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.gameObject = new HashMap<>();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         Graphics2D g2d = (Graphics2D) g;

        this.gameObject.forEach((key, value) -> {

        	g2d.setTransform(value);
        	
            g2d.drawImage(this.getImageFromEngine(key.getEngineImage()), null, null);

            g2d.drawRect(0, (int) key.getSize().getHeight() + 1, (int) key.getSize().getWidth(), 11);
            g2d.fillRect(0, (int) key.getSize().getHeight(), 50, 10);

        });
    }

    public void addGameObject(final GameObject gameObject, final AffineTransform transform) {
        this.gameObject.put(gameObject, transform);
        this.repaint();
    }

    public void deleteGameObject(final GameObject gameObject){
        this.gameObject.remove(gameObject);
        this.repaint();
    }

    private Image getImageFromEngine(final ImageDesign image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }

    
    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){
        AffineTransform aff = new AffineTransform();
        aff.setTransform(transform);
        
        //System.out.println(g2d.getTransform());
//
        aff.translate(0, gameObject.getSize().getHeight());
        g2d.setColor(Color.WHITE);
   
        //g2d.setTransform(gameObject.getTransform());
        //g2d.getTransform().translate(0, gameObject.getSize().getHeight());
        g2d.setTransform(aff);
        g2d.drawRect(0, 0, (int)gameObject.getSize().getWidth(), 11);
        aff.setToTranslation(0, 0);
        g2d.setTransform(aff);

    }

    private void drawLife(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){
//        AffineTransform aff = new AffineTransform();
//        aff.setTransform(transform);
//
//        aff.translate(0, gameObject.getSize().getHeight());
//
//        g2d.setColor(Color.GREEN);
//        g2d.setTransform(aff);
        g2d.fillRect(0, (int) gameObject.getSize().getHeight() + 1, 500, 10);
    }

    private int getDistanceTwoPoint(final P2d p1 , final P2d p2){
        return (int)Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) +
                Math.pow((p2.getY() - p1.getY()), 2));
    }
}