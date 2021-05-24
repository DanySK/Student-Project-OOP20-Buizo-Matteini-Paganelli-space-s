package spaceSurvival.view.game.utilities.logicColor;

import java.awt.*;

public class LogicColorShip implements LogicColor{
    @Override
    public Color setColor(final int value) {
        double maxHealth = 100;
        double maxColValue = 255;

        double redValue = (value > (maxHealth / 2) ? 1 - 2 * (value - (maxHealth / 2)) / maxHealth : 1.0) * maxColValue;
        double greenValue = (value > (maxHealth / 2) ? 1.0 : 2 * value / maxHealth) * maxColValue;
        double blueValue = 0;

        System.out.println("COLORRRR LIFE SHIP -> " + redValue + " " + greenValue + " " + blueValue);
        return value != 0 ?
                new Color((int) redValue, (int) greenValue, (int) blueValue) : Color.RED;
    }

}
