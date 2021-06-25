package spacesurvival.utilities.path.animation;

import spacesurvival.utilities.path.MainFolder;

import java.util.List;

public class AnimationChase {
    public static final String ENEMIES = "/enemies";
    public static final String TYPE = "/chase";

    public static final String CHASE0 = MainFolder.GAME_OBJECT + ENEMIES + TYPE + "/chase.png";
    public static final String CHASE1 = MainFolder.GAME_OBJECT + ENEMIES + TYPE + "/chase_1.png";
    public static final String CHASE2 = MainFolder.GAME_OBJECT + ENEMIES + TYPE + "/chase_2.png";
    public static final String CHASE3 = MainFolder.GAME_OBJECT + ENEMIES + TYPE + "/chase_3.png";
    public static final String CHASE4 = MainFolder.GAME_OBJECT + ENEMIES + TYPE + "/chase_4.png";

    public static final List<String> LIST_CHASE = List.of(CHASE1, CHASE2, CHASE3, CHASE4);
}
