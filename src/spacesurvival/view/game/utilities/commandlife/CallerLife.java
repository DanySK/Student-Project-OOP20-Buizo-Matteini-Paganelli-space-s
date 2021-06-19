package spacesurvival.view.game.utilities.commandlife;

import java.awt.Graphics2D;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.fireable.Boss;
import spacesurvival.model.gameobject.fireable.FireEnemy;
import spacesurvival.model.gameobject.main.Asteroid;
import spacesurvival.model.gameobject.main.ChaseEnemy;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.view.game.utilities.PanelEntityGame;
import spacesurvival.view.game.utilities.commandlife.command.LifeAsteroid;
import spacesurvival.view.game.utilities.commandlife.command.LifeBoss;
import spacesurvival.view.game.utilities.commandlife.command.LifeChase;
import spacesurvival.view.game.utilities.commandlife.command.LifeFireEnemy;
import spacesurvival.view.game.utilities.logicColor.LogicColor;

public class CallerLife {
    private final LogicColor logicColor;
    private final Graphics2D g2d;
    private final MainObject gameObject;
    
    private final CommandLife commandBoss;
    private final CommandLife commandChase;
    private final CommandLife commandFire;
    private final CommandLife commandAsteroid;
    
    
    public CallerLife(final MainObject gameObject, final LogicColor logicColor, final Graphics2D g2d) {
        this.logicColor = logicColor;
        this.gameObject = gameObject;
        this.g2d = g2d;
      
        this.commandBoss = new LifeBoss();
        this.commandChase = new LifeChase();
        this.commandFire = new LifeFireEnemy();
        this.commandAsteroid = new LifeAsteroid();
    }
    
    public void drawLife() {
        if(this.gameObject instanceof ChaseEnemy){
            this.g2d.setColor(this.logicColor.setColor(GameObjectUtils.CHASE_ENEMY_LIFE, this.gameObject.getLife()));
            g2d.fillRect(PanelEntityGame.ANCHOR_X_LIFE_BAR, (int) gameObject.getSize().getHeight() + PanelEntityGame.DIFFERENCE_HEIGHT_LIFE_BAR,
                    this.commandChase.execute(gameObject), PanelEntityGame.HEIGHT_LIFE);
            
        } else if(this.gameObject instanceof Asteroid){
            this.g2d.setColor(this.logicColor.setColor(GameObjectUtils.ASTEROID_LIFE, this.gameObject.getLife()));
            g2d.fillRect(PanelEntityGame.ANCHOR_X_LIFE_BAR, (int) gameObject.getSize().getHeight() + PanelEntityGame.DIFFERENCE_HEIGHT_LIFE_BAR,
                    this.commandAsteroid.execute(gameObject), PanelEntityGame.HEIGHT_LIFE);
            
        } else if(this.gameObject instanceof Boss){
            this.g2d.setColor(this.logicColor.setColor(GameObjectUtils.BOSS_LIFE, this.gameObject.getLife()));
            g2d.fillRect(PanelEntityGame.ANCHOR_X_LIFE_BAR, (int) gameObject.getSize().getHeight() + PanelEntityGame.DIFFERENCE_HEIGHT_LIFE_BAR,
                    this.commandBoss.execute(gameObject), PanelEntityGame.HEIGHT_LIFE);
            
        } else if(this.gameObject instanceof FireEnemy){
            this.g2d.setColor(this.logicColor.setColor(GameObjectUtils.FIRE_ENEMY_LIFE, this.gameObject.getLife()));
            g2d.fillRect(PanelEntityGame.ANCHOR_X_LIFE_BAR, (int) gameObject.getSize().getHeight() + PanelEntityGame.DIFFERENCE_HEIGHT_LIFE_BAR,
                    this.commandFire.execute(gameObject), PanelEntityGame.HEIGHT_LIFE);
        }
        
    }
    
}
