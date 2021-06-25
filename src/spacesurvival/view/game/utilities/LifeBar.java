package spacesurvival.view.game.utilities;

import javax.swing.JProgressBar;

import spacesurvival.utilities.gameobject.LifeUtils;
import spacesurvival.view.game.utilities.logicColor.LogicColor;

public class LifeBar extends JProgressBar {
    private static final long serialVersionUID = 3237184366293073643L;

    private final LogicColor logicColor;

    public LifeBar(final LogicColor logicColor) {
        super();
        super.setStringPainted(true);
        this.logicColor = logicColor;
    }

    /**
     * Set value of progress bar.
     * @param life
     */
    public void setLife(final int life) {
        super.setValue(life);
        super.setForeground(this.logicColor.setColor(LifeUtils.SPACESHIP_LIFE, life));
    } 

    @Override
    public String getString() {
        return "Life " + super.getValue();
    }
}
