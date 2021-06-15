package utilities.pathImage.Skin;

import java.nio.file.Paths;
import java.util.List;

public class SkinAsteroid {
    public static final String MAIN_FOLDER = "gameObjects";
    public static final String ASTEROID  = "asteroid";

    public static final String ASTEROID0 = Paths.get(MAIN_FOLDER, ASTEROID, "asteroid.png").toString();
    public static final String ASTEROID1 = Paths.get(MAIN_FOLDER, ASTEROID, "asteroid_1.png").toString();
    public static final String ASTEROID2 = Paths.get(MAIN_FOLDER, ASTEROID, "asteroid_2.png").toString();
    public static final String ASTEROID3 = Paths.get(MAIN_FOLDER, ASTEROID, "asteroid_3.png").toString();
    public static final String ASTEROID4 = Paths.get(MAIN_FOLDER, ASTEROID, "asteroid_4.png").toString();

    public static final List<String> LIST_ASTEROID = List.of(ASTEROID1, ASTEROID2, ASTEROID3, ASTEROID4);
}
