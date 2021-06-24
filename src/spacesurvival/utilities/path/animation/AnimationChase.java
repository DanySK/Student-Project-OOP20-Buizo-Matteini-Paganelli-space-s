package spacesurvival.utilities.path.animation;

import spacesurvival.utilities.path.MainFolder;

import java.nio.file.Paths;
import java.util.List;

public class AnimationChase {
    public static final String ENEMIES = "enemies";
    public static final String TYPE = "chase";

    public static final String CHASE0 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "chase.png").toString();

    public static final String CHASE1 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "chase_1.png").toString();
    public static final String CHASE2 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "chase_2.png").toString();
    public static final String CHASE3 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "chase_3.png").toString();
    public static final String CHASE4 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "chase_4.png").toString();

    public static final List<String> LIST_CHASE = List.of(CHASE1, CHASE2, CHASE3, CHASE4);
}
