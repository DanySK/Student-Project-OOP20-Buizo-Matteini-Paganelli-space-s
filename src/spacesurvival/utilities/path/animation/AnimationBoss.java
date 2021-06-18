package spacesurvival.utilities.path.animation;

import spacesurvival.utilities.path.MainFolder;

import java.nio.file.Paths;

public final class AnimationBoss {
    public static final String ENEMIES = "enemies";
    public static final String TYPE = "boss";

    public static final String BOSS0 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "boss.png").toString();
}
