package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
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
        final Graphics2D g2d = (Graphics2D) g;

        this.gameObject.forEach((key, value) -> {
            g2d.drawImage(this.getImageFromPath(key.getEngineImage()), value, null);
            RectBoundingBox rbb = (RectBoundingBox) key.getBoundingBox();
            
            
            
            
            
            double m00 = value.getScaleX();
            
            double m01 = value.getShearX();
            double angle = Math.atan2(-m01, m00);
            
            
            AffineTransform newAff = new AffineTransform();
            newAff.setToTranslation(value.getTranslateX(), value.getTranslateY());
            
            newAff.rotate(angle, key.getPosition().getX(), key.getPosition().getY());

            //newAff.translate(0, key.getSize().getHeight() * 2);

            
            //), gameObject.getSize().getWidth()/2, gameObject.getSize().getHeight()/2);
           
            
            g2d.setTransform(newAff);
            //g2d.setColor(Color.GREEN);
            
            
            
            
            //g2d.setTransform(rbb.getTransform());
            g2d.drawRect((int)value.getTranslateX(), (int)value.getTranslateY(), (int)rbb.getWidth(), (int)rbb.getHeight());
            
            this.drawLifeBar(g2d, (MainGameObject) key, value);
            this.drawLife(g2d, (MainGameObject) key, value);
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

    private Image getImageFromPath(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }


    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){
      
    	final BoundingBox rect = gameObject.getBoundingBox();    
        double m00 = transform.getScaleX();
        double m01 = transform.getShearX();

        final int x = (int) (transform.getTranslateX());
        final int y = (int) (transform.getTranslateY());
    
        double angle = Math.atan2(-m01, m00);
        
        AffineTransform newAff = new AffineTransform();

        newAff.setToTranslation(transform.getTranslateX(), transform.getTranslateY());      
        newAff.rotate(angle, gameObject.getPosition().getX(), gameObject.getPosition().getY());
        newAff.translate(0, gameObject.getSize().getHeight());


        g2d.setTransform(newAff);
        g2d.setColor(Color.WHITE);

        g2d.fillRect(x, y, (int)gameObject.getSize().getWidth(), 11);

    }


    private void drawLife(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){

        final BoundingBox rect = gameObject.getBoundingBox();
        
        double m00 = transform.getScaleX();
        double m01 = transform.getShearX();

        final int x = (int) (transform.getTranslateX());
        final int y = (int) (transform.getTranslateY());

         
        double angle = Math.atan2(-m01, m00);
        
        AffineTransform newAff = new AffineTransform();

        newAff.setToTranslation(transform.getTranslateX(), transform.getTranslateY());      
        newAff.rotate(angle, gameObject.getPosition().getX(), gameObject.getPosition().getY());
        newAff.translate(0, gameObject.getSize().getHeight() );


        g2d.setTransform(newAff);
        g2d.setColor(Color.GREEN);

        g2d.fillRect(x, y, 50, 11);
    }
}