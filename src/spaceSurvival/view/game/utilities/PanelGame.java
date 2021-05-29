package spaceSurvival.view.game.utilities;

import spaceSurvival.model.World;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.gameObject.mainGameObject.ChaseEnemy;
import spaceSurvival.model.gameObject.mainGameObject.FireEnemy;
import spaceSurvival.model.gameObject.weapon.Bullet;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.List;

public class PanelGame extends JPanel{
    private final Map<GameObject, AffineTransform> gameObject;
    private final List<Bullet> listBullet;

    private World world;

    private final Thread firstDrawer;
    private final Thread secondDrawer;
    private final Thread thirdDrawer;
    private final Thread fourthDrawer;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
        this.gameObject = new HashMap<>();
        this.listBullet = new ArrayList<>();

        this.firstDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.secondDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.thirdDrawer = new Thread(PanelGame.this::runSecondDrawer);
        this.fourthDrawer = new Thread(PanelGame.this::runSecondDrawer);
    }

    public void setWorld(final World world){
        this.world = world;
    }

    public void startPaint(){
        this.firstDrawer.start();
        this.secondDrawer.start();
        this.thirdDrawer.start();
        this.fourthDrawer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

//        g2d.setTransform(this.world.getShip().getTransform());
//        g2d.drawImage(EngineImage.getImageFromEngine(this.world.getShip().getEngineImage()), null, null);

        this.world.getAllEntities().forEach(entity -> {
            g2d.setTransform(entity.getTransform());
            g2d.drawImage(EngineImage.getImageFromEngine(entity.getEngineImage()), null, null);
            
            if(entity instanceof ChaseEnemy || entity instanceof FireEnemy || entity instanceof Asteroid) {
                this.drawLifeBar(g2d, entity);
            }
        });



//
//        this.world.getShip().getWeapon().get().getShootedBullets().forEach(bullet -> {
//            g2d.setTransform(bullet.getTransform());
//            g2d.drawImage(EngineImage.getImageFromEngine(bullet.getEngineImage()), null, null);
//        });


        System.out.println("N bullet -> " + this.world.getShip().getWeapon().get().getShootedBullets().size());
    }


    public void runSecondDrawer(){
        while (true){
            super.repaint();
            this.repaint();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBullet(){
        this.gameObject.forEach((gameObject, objTransform) -> {
            if (gameObject instanceof MainGameObject) {
                MainGameObject mainObject = (MainGameObject) gameObject;
                if (mainObject.getWeapon().isPresent()) {
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