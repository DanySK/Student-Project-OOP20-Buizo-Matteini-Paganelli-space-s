package view.game.utilities;

import view.game.utilities.logicColor.LogicColor;

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
        super.setForeground(this.logicColor.setColor(life));
    }

    @Override
    public String getString() {
        return "Life " + super.getValue();
    }
}
