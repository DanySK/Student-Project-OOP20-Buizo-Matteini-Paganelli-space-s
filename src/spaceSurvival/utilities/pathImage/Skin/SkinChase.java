package spaceSurvival.utilities.pathImage.Skin;

import java.nio.file.Paths;
import java.util.List;

public class SkinChase {
    public static final String MAIN_FOLDER = "gameObjects";
    public static final String ENEMIES = "enemies";
    public static final String TYPE = "chase";

    public static final String CHASE0 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "chase.png").toString();

    public static final String POOH0 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "pooh_1.png").toString();
    public static final String POOH1 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "pooh_2.png").toString();
    public static final String POOH2 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "pooh_3.png").toString();
    public static final String POOH3 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "pooh_4.png").toString();
    public static final String POOH4 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "pooh_5.png").toString();
    public static final String POOH5 = Paths.get(MAIN_FOLDER, ENEMIES, TYPE, "pooh_6.png").toString();

    public static final List<String> LIST_POOH = List.of(POOH0, POOH1, POOH2, POOH3, POOH4, POOH5);
}
