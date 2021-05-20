package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.image.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Skin;
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

            BoundingBox bb = key.getBoundingBox();

            //g2d.drawImage(this.getImageFromPath(new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN, Skin.ATOMIC)), bb.getTransform(), null);
           // g2d.drawRect((int)bb.getTransform().getTranslateX(), (int)bb.getTransform().getTranslateY(), (int) key.getSize().getWidth(),  (int) key.getSize().getHeight());
            //RectBoundingBox rbb =  (RectBoundingBox) key.getBoundingBox();
            
            //double m00 = value.getScaleX();
            //double m01 = value.getShearX();
            //double angle = Math.atan2(-m01, m00);
            
            
            //AffineTransform newAff = new AffineTransform();
            //newAff.setToTranslation(value.getTranslateX(), value.getTranslateY());

            //rbb.getTransform().rotate(angle, key.getPosition().getX() + key.getEngineImage().getWidth()/2,  key.getPosition().getY()+ key.getEngineImage().getHeight()/2);

            g2d.setColor(Color.green);
            g2d.drawRect((int)key.getPosition().x, (int)key.getPosition().y, 5, 5);
            //newAff.translate(0, key.getSize().getHeight() * 2);
            
            //), gameObject.getSize().getWidth()/2, gameObject.getSize().getHeight()/2);
            
            //
            //g2d.setColor(Color.GREEN);

            //g2d.setTransform(rbb.getTransform());
            //g2d.drawRect((int)value.getTranslateX(), (int)value.getTranslateY(), (int)rbb.getWidth(), (int)rbb.getHeight());


           // g2d.drawRect((int)value.getTranslateX(), (int)value.getTranslateY(), (int) key.getEngineImage().getWidth(), (int) key.getEngineImage().getHeight());
            //System.out.println("Width drawing: - >" + key.getEngineImage().getWidth());
            //System.out.println("Height drawing: - >" + key.getEngineImage().getHeight());
            
            
            this.drawLifeBar(g2d, (MainGameObject) key, value);
            //this.drawLife(g2d, (MainGameObject) key, value);
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


    private void drawPoint(final  Graphics2D g2d, final GameObject gameObject){
        g2d.setColor(Color.WHITE);

        g2d.drawRect((int)gameObject.getPosition().x, (int)gameObject.getPosition().y, 5, 5);
    }

    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){
      
    	//final BoundingBox rect = gameObject.getBoundingBox();
        //double m00 = transform.getScaleX();
       // double m01 = transform.getShearX();

        //final int x = (int) (transform.getTranslateX());
        //final int y = (int) (transform.getTranslateY());
    
        //double angle = Math.atan2(-m01, m00);
        
        AffineTransform aff = new AffineTransform();
        aff.setTransform(transform);


        //aff.setToTranslation(transform.getTranslateX(), transform.getTranslateY());
        //newAff.rotate(angle, gameObject.getPosition().getX(), gameObject.getPosition().getY());
        //aff.setToTranslation(aff.getTranslateX(), aff.getTranslateY() + gameObject.getSize().getHeight());
        aff.translate(0, gameObject.getSize().getHeight());
    System.out.println("TranslateY -> "+aff.getTranslateY()+"TranslateX -> "+aff.getTranslateX()+"objectSizeHeight ->" +  gameObject.getSize().getHeight());

        //g2d.setTransform(aff);
        g2d.drawImage(this.getImageFromPath(new EngineImage(GameObjectUtils.SPACESHIP_SCALEOF, Screen.WIDTH_FULL_SCREEN, Skin.ATOMIC)), aff, null);


        //g2d.setColor(Color.WHITE);

        //g2d.fillRect(0,(int)gameObject.getEngineImage().getHeight(), (int)gameObject.getSize().getWidth(), 11);
        //g2d.setTransform(new AffineTransform());
    }


    private void drawLife(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){

        //final RectBoundingBox rect = (RectBoundingBox) gameObject.getBoundingBox();
        
        double m00 = transform.getScaleX();
        double m01 = transform.getShearX();

        final int x = (int) (transform.getTranslateX());
        final int y = (int) (transform.getTranslateY());

         
        double angle = Math.atan2(-m01, m00);
        
        AffineTransform newAff = new AffineTransform();

        newAff.setToTranslation(transform.getTranslateX(), transform.getTranslateY());      
        newAff.rotate(angle, gameObject.getPosition().getX(), gameObject.getPosition().getY());
        newAff.translate(0, gameObject.getEngineImage().getHeight());
//        System.out.println("aaaaaaaaaaaaaaaaa" + gameObject.getEngineImage().getHeight());



        g2d.setTransform(newAff);
        g2d.setColor(Color.GREEN);

        g2d.fillRect(x, y, 50, 11);
    }
}