package spaceSurvival.view.game.utilities;

import spaceSurvival.model.EngineMalaLoop;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.view.utilities.JImage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PanelGame extends JPanel implements Runnable{
    private final Map<GameObject, AffineTransform> gameObject;
    private volatile List<Bullet> listBullet;
    private final Thread secondDrawer;

    private final Lock _mutex;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.gameObject = new HashMap<>();
        this.listBullet = new ArrayList<>();
        this.secondDrawer = new Thread(this);
        this._mutex = new ReentrantLock(true);

//        this.secondDrawer.start();
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
        });

        updateBullet();
        this.listBullet.forEach(bullet -> {
            g2d.setTransform(bullet.getTransform());
            g2d.drawImage(this.getImageFromEngine(bullet.getEngineImage()), null, null);
        });
        System.out.println(this.listBullet.size() +  "      " + this.listBullet);
        this.listBullet.clear();

git 
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            int elapsed = (int)(current - lastTime);
            this.updateBullet();
            waitForNextFrame(current);
            lastTime = current;

        }
    }

    protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < EngineMalaLoop.FPS){
            try {
                Thread.sleep(EngineMalaLoop.FPS - dt);
            } catch (Exception ignored){}
        }
    }

    public synchronized void updateBullet(){
        this._mutex.lock();
        this.gameObject.forEach((gameObject, objTransform) -> {
            if (gameObject instanceof MainGameObject) {
                MainGameObject mainObject = (MainGameObject) gameObject;
                if (mainObject.getWeapon().isPresent()) {
//                    mainObject.getWeapon().get().getShootedBullets().forEach(bullet -> {
//                        this.listBullet.add(bullet);
//                    });
                    this.listBullet.addAll(mainObject.getWeapon().get().getShootedBullets());
                }
            }
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