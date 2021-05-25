package spaceSurvival.view.game.utilities;

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

public class PanelGame extends JPanel implements Runnable{
    private final Map<GameObject, AffineTransform> gameObject;
    private final Map<AffineTransform, EngineImage> mapBullet;

    private final Thread secondDrawer;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.gameObject = new HashMap<>();
        this.mapBullet = new HashMap<>();

        this.secondDrawer = new Thread(this);
        this.secondDrawer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         Graphics2D g2d = (Graphics2D) g;

        this.gameObject.forEach((gameObject, objTransform) -> {

        	g2d.setTransform(objTransform);
        	
            g2d.drawImage(this.getImageFromEngine(gameObject.getEngineImage()), null, null);

            g2d.drawRect(0, (int) gameObject.getSize().getHeight() + 1, (int) gameObject.getSize().getWidth(), 11);
            g2d.fillRect(0, (int) gameObject.getSize().getHeight(), 50, 10);

            this.mapBullet.entrySet().forEach(bullet -> {
                g2d.setTransform(bullet);
                g2d.drawImage(this.getImageFromEngine(bullet.get), null, null);
            });


        });
    }

    @Override
    public void run() {

    }

    public void updateBullet(){
        if (gameObject instanceof MainGameObject) {
            MainGameObject mainObject = (MainGameObject) gameObject;
            if (mainObject.getWeapon().isPresent()) {
                mainObject.getWeapon().get().getShootedBullets().forEach(bullet -> {
                    this.mapBullet.put(bullet.getTransform(), this.getImageFromEngine(bullet.getEngineImage()));
                });
            }
        }
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