package spacesurvival.view.game.utilities;

import spacesurvival.model.World;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.Pair;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.Boss;
import spacesurvival.model.gameobject.enemy.ChaseEnemy;
import spacesurvival.model.gameobject.main.Asteroid;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.gameobject.weapon.Bullet;
import spacesurvival.utilities.ThreadUtils;
import spacesurvival.view.game.utilities.logicColor.LogicColor;
import spacesurvival.view.game.utilities.logicColor.LogicColorShip;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PanelEntityGame extends JPanel{
    private static final long serialVersionUID = -6158413043296871948L;
    
    private final Map<GameObject, Pair<Image, Image>> objects;
    private Optional<World> world;
    
    private final Thread taskObjects;

    public PanelEntityGame() {
        super(); 
        super.setOpaque(false);

        this.taskObjects = new Thread(PanelEntityGame.this::runUpdateGameObjects);
        this.objects = new HashMap<>();
        this.world = Optional.empty();

        this.taskObjects.start();
    }

    public void setWorld(final World world) {
        this.world = Optional.of(world);
    }

    @Override
    public final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

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


            if (this.isEnemy(entity.getKey())) {
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

    private void putObjectFromWorld() {
        this.world.get().getAllEntitiesExceptionBullets().forEach(obj -> {
            final Pair<Image, Image> pair = new Pair<>(obj.getImgBody(), obj.getImgEffect());
            this.objects.put(obj, pair);
        });
    }

    private void deletGameObject() {
        final Set<GameObject> objDelet = new HashSet<>();

        this.objects.forEach((key, value) -> {
            if (!this.world.get().getAllEntitiesExceptionBullets().contains(key)) {
                objDelet.add(key);
            }
        });

        objDelet.forEach(this.objects::remove);
    }

    public final void runUpdateGameObjects() {
        long lastTime = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();

            if (this.world.isPresent()) {
               this.updateGameObjects();
            }

         waitForNextFrame(current);
           lastTime = current;
        }
    }

    protected final void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < 60) {
            ThreadUtils.sleep(60 - dt);
        }
    }

}