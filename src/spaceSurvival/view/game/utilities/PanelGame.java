package spaceSurvival.view.game.utilities;

import spaceSurvival.model.World;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.EngineImage;
<<<<<<< HEAD

=======
import spaceSurvival.model.Pair;
>>>>>>> mala
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.gameObject.takeableGameObject.TakeableGameObject;
import spaceSurvival.model.gameObject.weapon.Bullet;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.CircleBoundingBox;

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
    
    private final Thread taskObjects;
    private final Thread firstDrawer;
    
    private Optional<World> world;

    private boolean isDraw;
    private boolean isUpdate;

    public PanelGame() {
        super(); {{ setOpaque(false); }}
      
        this.taskObjects = new Thread(PanelGame.this::runUpdateGameObjects);
        this.firstDrawer = new Thread(PanelGame.this::runDrawer);
        
        this.objects = new HashMap<>();
        
        this.isDraw = false;
        this.isUpdate = false;
        
        this.world = Optional.empty();
        
        this.taskObjects.start();
        this.firstDrawer.start();
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        
        this.objects.entrySet().stream().forEach(entity -> {
            if(entity.getKey().getBoundingBox() instanceof CircleBoundingBox) {
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
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, (int) gameObject.getSize().getHeight() + 1, (int)(gameObject.getSize().getWidth() / 2), 10);
    }

    private boolean isEnemy(final GameObject obj) {
        return !(obj instanceof SpaceShipSingleton || obj instanceof TakeableGameObject || obj instanceof Bullet);
    }
    
    private void updateGameObjects() {
        this.putMapFromWorld();
        this.deletGameObject();
        
    }
    
    private void putMapFromWorld() {
        this.world.get().getAllEntities().forEach(obj -> {
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
            if(!this.world.get().getAllEntities().contains(obj.getKey())) {
                objDelet.add(obj.getKey());
            }
        });
        
        objDelet.forEach(obj -> {
            if(this.objects.containsKey(obj)) {
                this.objects.remove(obj);
            }
        });
    }
    
    
    public void runDrawer(){
        long lastTime = System.currentTimeMillis();
        
        while (true){
            long current = System.currentTimeMillis();
            
            if(this.isDraw){ 
                this.repaint();
            }

            waitForNextFrame(current);
            lastTime = current;
        }
    }
    
    public void runUpdateGameObjects() {
        long lastTime = System.currentTimeMillis();
        
        while(true) {
            long current = System.currentTimeMillis();
            
           if(this.isUpdate && this.world.isPresent()) {
               this.updateGameObjects();
           }
            
           waitForNextFrame(current);
           lastTime = current;
        }
    }
    
    protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < 80){
            try {
                Thread.sleep(80 - dt);
            } catch (Exception ignored){}
        }
    }

   
}