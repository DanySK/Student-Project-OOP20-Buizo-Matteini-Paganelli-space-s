package spaceSurvival.utilities.pathImage;

import java.nio.file.Paths;

public class Enemies {
    public static final String MAIN_FOLDER = "gameObjects";

    public static final String TYPE = "enemies";

    public static final String CHASE = Paths.get(MAIN_FOLDER, TYPE, "chase.png").toString();
}
