package spacesurvival.view.game.utilities;

import spacesurvival.model.World;
import spacesurvival.model.collisioni.physics.bounding.CircleBoundingBox;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.EngineImage;
import spacesurvival.model.Pair;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.Boss;
import spacesurvival.model.gameobject.enemy.ChaseEnemy;
import spacesurvival.model.gameobject.main.Asteroid;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.gameobject.weapon.Bullet;

import spacesurvival.view.game.utilities.logicColor.LogicColor;
import spacesurvival.view.game.utilities.logicColor.LogicColorShip;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PanelGame extends JPanel{
    private static final long serialVersionUID = -6158413043296871948L;

    private final Map<GameObject, Pair<Image, Image>> objects;
    private final Map<Bullet, Pair<Image, Image>> bullets;

    private final Thread taskObjects;
    private final Thread taskBullet;

    private Optional<World> world;

    private boolean isDraw;
    private boolean isUpdate;

    public PanelGame() {
        super(); 
        super.setOpaque(false);

        this.taskObjects = new Thread(PanelGame.this::runUpdateGameObjects);
        this.taskBullet = new Thread(PanelGame.this::runUpdateBullet);
        this.objects = new HashMap<GameObject, Pair<Image, Image>>();
        this.bullets = new HashMap<Bullet, Pair<Image,Image>>();
        this.isDraw = false;
        this.isUpdate = false;
        
        this.world = Optional.empty();
        
        this.taskObjects.start();
        this.taskBullet.start();
    }

    public void setWorld(final World world) {
        this.world = Optional.of(world);
    }

    public void startPaint() {
        this.isDraw = true;
        this.isUpdate = true;
    }

    public void stopPaint() {
        this.isDraw = false;
        this.isUpdate = false;
    }

    @Override
    public final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        this.bullets.forEach((key, value) -> {
            g2d.setTransform(key.getTransform());
            g2d.drawImage(value.getX(), 0, 0, null);
            g2d.drawImage(value.getY(), 0, 0, null);
        });

        this.objects.entrySet().forEach(entity -> {
            if (entity.getKey().getBoundingBox() instanceof CircleBoundingBox) {
                AffineTransform transform = new AffineTransform();
               transform.setTransform(entity.getKey().getTransform());
                CircleBoundingBox cbb = (CircleBoundingBox) entity.getKey().getBoundingBox();
                transform.translate(-cbb.getRadius(), -cbb.getRadius());
                g2d.setTransform(transform);
            }
            else {
                g2d.setTransform(entity.getKey().getTransform());
            }

            g2d.drawImage(entity.getValue().getX(), 0, 0, null);
            g2d.drawImage(entity.getValue().getY(), 0, 0, null);


            if(this.isEnemy(entity.getKey())) {
                this.drawLifeBar(g2d, entity.getKey());
            }
        });
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
        final LogicColor logicColor = new LogicColorShip();
        int life = Math.max(((MainGameObject) gameObject).getLife(), 0);
        if(gameObject instanceof ChaseEnemy){
            g2d.setColor(logicColor.setColor(GameObjectUtils.CHASE_ENEMY_LIFE, life));
            life = (int) (life * gameObject.getWidth() / GameObjectUtils.CHASE_ENEMY_LIFE);
        }
        if(gameObject instanceof Asteroid){
            g2d.setColor(logicColor.setColor(GameObjectUtils.ASTEROID_LIFE, life));
            life = (int) (life * gameObject.getWidth() / GameObjectUtils.ASTEROID_LIFE);
        }
        if(gameObject instanceof Boss){
            g2d.setColor(logicColor.setColor(GameObjectUtils.BOSS_LIFE, life));
            life = (int) (life * gameObject.getWidth() / GameObjectUtils.BOSS_LIFE);
        }



        g2d.fillRect(0, (int) gameObject.getSize().getHeight() + 1, life, 10);
    }

    private boolean isEnemy(final GameObject obj) {
        return !(obj instanceof SpaceShipSingleton || obj instanceof TakeableGameObject || obj instanceof Bullet);
    }
    
    private void updateGameObjects() {
        this.putObjectFromWorld();
        this.deletGameObject();
        
    }
    
    private void updateBulletObject() {
        this.world.get().getAllBullets().forEach(bullet -> {
            final Bullet entity = bullet;
            final Pair<Image, Image> pair = new Pair<>(EngineImage.getImageFromEngine(entity.getEngineImage()), 
                    EngineImage.getImageFromEngine(entity.getEngineEffect()));
            
            if(this.bullets.containsKey(entity)) {
                this.bullets.replace(entity, pair);
            } else {
                this.bullets.put(entity, pair);
            }     
            this.bullets.put(entity, pair);
        });
        
        final Set<Bullet> bulletDelet = new HashSet<>();
        
        this.bullets.entrySet().forEach(obj -> {
            if(!this.world.get().getAllBullets().contains(obj.getKey())) {
                bulletDelet.add(obj.getKey());
            }
        });
        
        bulletDelet.forEach(obj -> {
            if(this.bullets.containsKey(obj)) {
                this.bullets.remove(obj);
            }
        });
        
    }
    
    private void putObjectFromWorld() {

        this.world.get().getAllEntitiesException().forEach(obj -> {
            final GameObject entity = obj;
            final Pair<Image, Image> pair = new Pair<>(EngineImage.getImageFromEngine(entity.getEngineImage()), 
                    EngineImage.getImageFromEngine(entity.getEngineEffect()));
            
            if(this.objects.containsKey(entity)) {
                this.objects.replace(entity, pair);
            } else {
                this.objects.put(entity, pair);
            }     
            this.objects.put(entity, pair);
        });
    }
    
    private void deletGameObject() {
        final Set<GameObject> objDelet = new HashSet<>();
        
        this.objects.entrySet().forEach(obj -> {
            if (!this.world.get().getAllEntitiesException().contains(obj.getKey())) {
                objDelet.add(obj.getKey());
            }
        });
        
        objDelet.forEach(obj -> {
            if (this.objects.containsKey(obj)) {
                this.objects.remove(obj);
            }
        });
    }

    public void runUpdateBullet() {
        long lastTime = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            
           if (this.isUpdate && this.world.isPresent()) {
               this.updateBulletObject();
           }
            
       
           try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
//           waitForNextFrame(current);
           lastTime = current;
        }
    }
    
    public final void runUpdateGameObjects() {
        long lastTime = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            
           if(this.isUpdate && this.world.isPresent()) {
               this.updateGameObjects();
           }

           try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
//           waitForNextFrame(current);
           lastTime = current;
        }
    }
    
    protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < 60){
            try {
                Thread.sleep(60 - dt);
            } catch (Exception ignored){}
        }
    }

   
}