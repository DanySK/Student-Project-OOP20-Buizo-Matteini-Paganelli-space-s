package spacesurvival.utilities.path.animation;

import spacesurvival.utilities.path.MainFolder;
import java.nio.file.Paths;

public final class AnimationBoss {
    /**
     * Name of the package of enemies animations.
     */
    public static final String ENEMIES = "enemies";
    /**
     * Name of the package of boss animations.
     */
    public static final String TYPE = "boss";

    /**
     * Icon of the boss.
     */
    public static final String BOSS0 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "boss.png").toString();
    private AnimationBoss() {

    }
}
