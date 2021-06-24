package spacesurvival.utilities.path.animation;

import java.nio.file.Paths;
import java.util.List;
import spacesurvival.utilities.path.MainFolder;

public final class AnimationAsteroid {
    /**
     * Name of the package of asteroids' animations.
     */
    public static final String ASTEROID  = "asteroid";
    /**
     * Asteroid animation 0.
     */
    public static final String ASTEROID0 = Paths.get(MainFolder.GAME_OBJECT, ASTEROID, "asteroid.png").toString();
    /**
     * Asteroid animation 1.
     */
    public static final String ASTEROID1 = Paths.get(MainFolder.GAME_OBJECT, ASTEROID, "asteroid_1.png").toString();
    /**
     * Asteroid animation 2.
     */
    public static final String ASTEROID2 = Paths.get(MainFolder.GAME_OBJECT, ASTEROID, "asteroid_2.png").toString();
    /**
     * Asteroid animation 3.
     */
    public static final String ASTEROID3 = Paths.get(MainFolder.GAME_OBJECT, ASTEROID, "asteroid_3.png").toString();
    /**
     * Asteroid animation 4.
     */
    public static final String ASTEROID4 = Paths.get(MainFolder.GAME_OBJECT, ASTEROID, "asteroid_4.png").toString();
    /**
     * List of asteroids animation.
     */
    public static final List<String> LIST_ASTEROID = List.of(ASTEROID1, ASTEROID2, ASTEROID3, ASTEROID4);

    private AnimationAsteroid() {

    }
}
