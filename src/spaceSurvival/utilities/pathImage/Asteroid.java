package spaceSurvival.utilities.pathImage;

import java.nio.file.Paths;

public class Asteroid {
    public static final String MAIN_FOLDER = "gameObjects";
    public static final String TYPE_ASTEROID = "asteroid";


    public static final String NORMAL = Paths.get(MAIN_FOLDER, TYPE_ASTEROID, "asteroid.png").toString();

}
