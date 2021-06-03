package spaceSurvival.view.game.utilities;

import spaceSurvival.model.World;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.List;

public class PanelGame extends JPanel{
    private final List<Bullet> listBullet;

    private World world;

    private final Thread firstDrawer;
    private final Thread secondDrawer;
    private final Thread thirdDrawer;
    private final Thread fourthDrawer;

    private boolean isDraw;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.listBullet = new ArrayList<>();
        this.isDraw = false;

        this.firstDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.secondDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.thirdDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.fourthDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.firstDrawer.start();
        this.secondDrawer.start();
        this.thirdDrawer.start();
        this.fourthDrawer.start();
    }

    public void setWorld(final World world){
        this.world = world;
    }

    public void startPaint(){
        this.isDraw = true;

    }

    public void stopDrawer(){
        this.isDraw = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

//        g2d.setTransform(this.world.getShip().getTransform());
//        g2d.drawImage(EngineImage.getImageFromEngine(this.world.getShip().getEngineImage()), null, null);

        this.world.getAllEntities().forEach(entity -> {
        	
//        	System.out.println("-------------------------------");
//        	System.out.println(entity.toString());
//        	System.out.println(entity.getBoundingBox().toString());
//        	System.out.println(entity.getTransform());
        	
        	if(entity.getBoundingBox() instanceof CircleBoundingBox) {
        		AffineTransform transform = new AffineTransform();
        		transform.setTransform(entity.getTransform());     		
        		CircleBoundingBox cbb = (CircleBoundingBox) entity.getBoundingBox();
        		transform.translate(-cbb.getRadius(), -cbb.getRadius());
        		g2d.setTransform(transform);
        	}
        	else {
        		g2d.setTransform(entity.getTransform());
        	}

            g2d.drawImage(EngineImage.getImageFromEngine(entity.getEngineImage()), 0,0, null);
            g2d.drawImage(EngineImage.getImageFromEngine(entity.getEngineEffect()), 0,0, null);

            g2d.setColor(Color.WHITE);
            g2d.drawRect(0, 0, (int)entity.getEngineImage().getSize().getWidth(), (int)entity.getEngineImage().getSize().getHeight());

            if(!(entity instanceof SpaceShipSingleton || entity instanceof TakeableGameObject || entity instanceof Bullet)) {
                this.drawLifeBar(g2d, entity);
            }

        });

//<<<<<<< HEAD
//        updateBullet();
//        this.listBullet.forEach(bullet -> {
//            g2d.setTransform(bullet.getTransform());
//            g2d.drawImage(this.getImageFromEngine(bullet.getEngineImage()), null, null);
//        });
//
//        this.listBullet.clear();
//=======


//
//        this.world.getShip().getWeapon().get().getShootedBullets().forEach(bullet -> {
//            g2d.setTransform(bullet.getTransform());
//            g2d.drawImage(EngineImage.getImageFromEngine(bullet.getEngineImage()), null, null);
//        });




    }


    public void runSecondDrawer(){
        while (true){

            if(this.isDraw){
                super.repaint();
                this.repaint();
            }


            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject){
        this.drawBar(g2d, gameObject);
        this.drawLife(g2d, gameObject);
    }
    
    private void drawBar(final Graphics2D g2d, final GameObject gameObject){
        g2d.setColor(Color.WHITE);
        g2d.drawRect(0, (int) gameObject.getSize().getHeight(), (int) gameObject.getSize().getWidth(), 11);
    }

    private void drawLife(final Graphics2D g2d, final GameObject gameObject){
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, (int) gameObject.getSize().getHeight() + 1, (int)(gameObject.getSize().getWidth() / 2), 10);
    }

    private int getDistanceTwoPoint(final P2d p1 , final P2d p2){
        return (int)Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) +
                Math.pow((p2.getY() - p1.getY()), 2));
    }


}