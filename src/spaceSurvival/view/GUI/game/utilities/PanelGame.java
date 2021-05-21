package spaceSurvival.view.GUI.game.utilities;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.EngineImage;
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

            g2d.setColor(Color.WHITE);
            g2d.drawRect((int)key.getTransform().getScaleX(), (int)key.getTransform().getScaleY(), 5, 5);

            g2d.setColor(Color.cyan);
            g2d.drawRect((int)key.getTransform().getShearX(), (int)key.getTransform().getScaleY(),
                    (int)key.getSize().getHeight()/2,
                    (int)key.getSize().getHeight()/2);


            this.drawPoint(g2d, (int)(key.getTransform().getShearX() + key.getSize().getHeight()/2),
                    (int)(key.getTransform().getShearY() + key.getSize().getHeight()/2));

            int x = (int)(key.getTransform().getShearX() + key.getSize().getHeight()/2);
            int y =  (int)(key.getTransform().getShearY() + key.getSize().getHeight()/2);
            int width = (int)key.getSize().getHeight()/2;

            int distance = this.getDistanceTwoPoint(
                    new P2d(key.getTransform().getTranslateX(), key.getTransform().getTranslateY()),
                    new P2d(x, y));




            if (key instanceof MainGameObject) {
                this.drawLifeBar(g2d, key, value);
                this.drawLife(g2d, key, value);
			}



//            AffineTransform aff = new AffineTransform();
//            aff.setTransform(key.getTransform());
//
//            aff.setToTranslation(key.getTransform().getShearX() - distance, key.getTransform().getShearY() - distance);
//
//            g2d.setTransform(aff);
//            drawProva(g2d, x, y, width * 2);
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


    private void drawPoint(final  Graphics2D g2d, int x, int y){
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 5, 5);
    }

    private void drawProva(final Graphics2D g2d, final int x, final int y, final int width){

        g2d.drawRect(x, y, width, 11);
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
        AffineTransform aff = new AffineTransform();
        aff.setTransform(transform);

        aff.translate(0, gameObject.getSize().getHeight());

        g2d.setColor(Color.GREEN);
        g2d.setTransform(aff);

        g2d.fillRect(0,1, 50, 10);
    }

    private int getDistanceTwoPoint(final P2d p1 , final P2d p2){
        return (int)Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) +
                Math.pow((p2.getY() - p1.getY()), 2));
    }
}