package spacesurvival.utilities.path.animation;

import spacesurvival.utilities.path.MainFolder;

import java.nio.file.Paths;
import java.util.List;

public class AnimationChase {
    public static final String ENEMIES = "enemies";
    public static final String TYPE = "chase";

    public static final String CHASE0 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "chase.png").toString();

    public static final String POOH0 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "pooh_1.png").toString();
    public static final String POOH1 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "pooh_2.png").toString();
    public static final String POOH2 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "pooh_3.png").toString();
    public static final String POOH3 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "pooh_4.png").toString();
    public static final String POOH4 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "pooh_5.png").toString();
    public static final String POOH5 = Paths.get(MainFolder.GAME_OBJECT, ENEMIES, TYPE, "pooh_6.png").toString();

    public static final List<String> LIST_POOH = List.of(POOH0, POOH1, POOH2, POOH3, POOH4, POOH5);
}
