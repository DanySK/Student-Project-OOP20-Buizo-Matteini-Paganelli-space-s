package spacesurvival.view.game.utilities.logicColor;

import java.awt.Color;

public class LogicColorShip implements LogicColor {
    @Override
    public Color setColor(final int maxLife, final int value) {
        final double maxColValue = 255;

        final double redValue = (value > ((double) maxLife / 2) ? 1 - 2 * (value - ((double) maxLife / 2)) / maxLife : 1.0) * maxColValue;
        final double greenValue = (value > ((double) maxLife / 2) ? 1.0 : 2 * value / (double) maxLife) * maxColValue;
        final double blueValue = 0;

        return value <= 0 ? Color.RED : value >= maxLife ? Color.GREEN : new Color((int) redValue, (int) greenValue, (int) blueValue);
    }

}
