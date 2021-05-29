package spaceSurvival.utilities.pathImage.Skin;

import java.nio.file.Paths;
import java.util.List;

public class SkinPerk {
    public static final String MAIN_FOLDER = "perk";

    public static final String ICE = "ice";
    public static final String FIRE = "fire";
    public static final String ELECTRIC = "electric";

    public static final String ICE0 = Paths.get(MAIN_FOLDER, ICE, "ice.png").toString();
    public static final String ICE1 = Paths.get(MAIN_FOLDER, ICE, "ice_1.png").toString();
    public static final String ICE2 = Paths.get(MAIN_FOLDER, ICE, "ice_2.png").toString();
    public static final String ICE3 = Paths.get(MAIN_FOLDER, ICE, "ice_3.png").toString();
    public static final String ICE4 = Paths.get(MAIN_FOLDER, ICE, "ice_4.png").toString();
    public static final String ICE5 = Paths.get(MAIN_FOLDER, ICE, "ice_5.png").toString();
    public static final String ICE6 = Paths.get(MAIN_FOLDER, ICE, "ice_6.png").toString();
    public static final String ICE7 = Paths.get(MAIN_FOLDER, ICE, "ice_7.png").toString();
    public static final String ICE8 = Paths.get(MAIN_FOLDER, ICE, "ice_8.png").toString();
    public static final String ICE9 = Paths.get(MAIN_FOLDER, ICE, "ice_9.png").toString();
    public static final String ICE10 = Paths.get(MAIN_FOLDER, ICE, "ice_10.png").toString();

    public static final List<String> LIST_ICE = List.of(ICE0, ICE1, ICE2, ICE3, ICE4, ICE5, ICE6, ICE7, ICE8, ICE9, ICE10);

    public static final String FIRE0 = Paths.get(MAIN_FOLDER, "fire.png").toString();
    public static final String ELECTRIC0 = Paths.get(MAIN_FOLDER, "electric.png").toString();
}
