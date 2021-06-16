package spacesurvival.view.game.utilities.logicColor;

import java.awt.Color;

public class LogicColorBoss implements LogicColor{
    @Override
    public Color setColor(final int maxLife, final int value) {
        return Color.RED;
    }
}
