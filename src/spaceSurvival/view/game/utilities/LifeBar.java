package spaceSurvival.view.game.utilities;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.view.game.utilities.logicColor.LogicColor;

import javax.swing.*;

public class LifeBar extends JProgressBar {
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
