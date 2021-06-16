package spaceSurvival.view.game.utilities.logicColor;

import java.awt.*;

public class LogicColorShip implements LogicColor{
    @Override
    public Color setColor(final int maxLife, final int value) {
        double maxColValue = 255;

        double redValue = (value > ((double) maxLife / 2) ? 1 - 2 * (value - ((double) maxLife / 2)) / (double) maxLife : 1.0) * maxColValue;
        double greenValue = (value > ((double) maxLife / 2) ? 1.0 : 2 * value / (double) maxLife) * maxColValue;
        double blueValue = 0;

        return value != 0 ?
                new Color((int) redValue, (int) greenValue, (int) blueValue) : Color.RED;
    }

}
