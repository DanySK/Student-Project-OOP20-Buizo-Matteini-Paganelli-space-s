package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.image.EngineImage;
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
            g2d.setTransform(value);
            g2d.drawImage(this.getImageFromEngine(key.getEngineImage()), null, null);

            g2d.setColor(Color.green);
            g2d.drawRect((int)key.getTransform().getTranslateX(), (int)key.getTransform().getTranslateY(), 10, 10);

            g2d.setColor(Color.WHITE);
            g2d.drawRect((int)key.getTransform().getScaleX(), (int)key.getTransform().getScaleY(), 5, 5);
//            if (key instanceof MainGameObject) {
                this.drawLifeBar(g2d, key, value);
                this.drawLife(g2d, key, value);
//			}
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

    private Image getImageFromEngine(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }


    private void drawPoint(final  Graphics2D g2d, final GameObject gameObject){
        g2d.setColor(Color.WHITE);

        g2d.drawRect((int)gameObject.getPosition().x, (int)gameObject.getPosition().y, 5, 5);
    }

    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){

        AffineTransform aff = new AffineTransform();
        aff.setTransform(transform);

        aff.translate(0, gameObject.getSize().getHeight());

        g2d.setColor(Color.WHITE);
        g2d.setTransform(aff);


        g2d.drawRect((int) 0,0, (int)gameObject.getSize().getHeight(), 11);

    }


    private void drawLife(final Graphics2D g2d, final GameObject gameObject, final AffineTransform transform){

        //final RectBoundingBox rect = (RectBoundingBox) gameObject.getBoundingBox();
        
//        double m00 = transform.getScaleX();
//        double m01 = transform.getShearX();
//
//        final int x = (int) (transform.getTranslateX());
//        final int y = (int) (transform.getTranslateY());
//
//
//        double angle = Math.atan2(-m01, m00);
//
//        AffineTransform newAff = new AffineTransform();
//
//        newAff.setToTranslation(transform.getTranslateX(), transform.getTranslateY());
//        newAff.rotate(angle, gameObject.getPosition().getX(), gameObject.getPosition().getY());
//        newAff.translate(0, gameObject.getEngineImage().getHeight());
//        System.out.println("aaaaaaaaaaaaaaaaa" + gameObject.getEngineImage().getHeight());
//
//
//        g2d.setTransform(newAff);
//        g2d.setColor(Color.GREEN);
//
//        g2d.fillRect(x, y, 50, 11);

        AffineTransform aff = new AffineTransform();
        aff.setTransform(transform);

        aff.translate(0, gameObject.getSize().getHeight());

        g2d.setColor(Color.GREEN);
        g2d.setTransform(aff);

        g2d.fillRect((int) 0,1, 50, 10);
    }
}