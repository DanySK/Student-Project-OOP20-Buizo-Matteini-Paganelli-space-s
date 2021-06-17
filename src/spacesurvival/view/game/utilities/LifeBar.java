package spacesurvival.view.game.utilities;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.view.game.utilities.logicColor.LogicColor;

import javax.swing.*;

public class LifeBar extends JProgressBar {
    private static final long serialVersionUID = 3237184366293073643L;
    
    private final LogicColor logicColor;

    public LifeBar(final LogicColor logicColor){
        super();
        super.setStringPainted(true);
        this.logicColor = logicColor;
    }
   
    public void setLife(final int life){
        super.setValue(life);
        super.setForeground(this.logicColor.setColor(GameObjectUtils.SPACESHIP_LIFE, life));
    }


    @Override
    public String getString() {
        return "Life " + super.getValue();
    }
}
