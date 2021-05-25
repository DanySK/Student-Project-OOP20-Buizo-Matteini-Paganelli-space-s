package spaceSurvival.utilities.pathImage;

import java.nio.file.Paths;
import java.util.List;

public class Skin {

    public static final String MAIN_FOLDER = "gameObjects";
    public static final String SHIP_FOLDER = "spaceship";

    public static final String TYPE_SHIP_1 = "ship1";
    public static final String TYPE_SHIP_2 = "ship2";
    public static final String TYPE_SHIP_3 = "ship3";
    public static final String TYPE_SHIP_4 = "ship4";

    public static final String SPECIAL0 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_1, "ship1.png").toString();
    public static final String SPECIAL1 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_1, "ship1_1.png").toString();
    public static final String SPECIAL2 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_1, "ship1_2.png").toString();
    public static final String SPECIAL3 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_1, "ship1_3.png").toString();
    public static final String SPECIAL4 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_1, "ship1_4.png").toString();

    public static final List<String> LIST_SHIP1 = List.of(SPECIAL0, SPECIAL1, SPECIAL2, SPECIAL3, SPECIAL4);


    public static final String STANDARD0 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2.png").toString();
    public static final String STANDARD1 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2_1.png").toString();
    public static final String STANDARD2 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2_2.png").toString();
    public static final String STANDARD3 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2_3.png").toString();
    public static final String STANDARD4 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2_4.png").toString();
    public static final String STANDARD5 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2_5.png").toString();
    public static final String STANDARD6 = Paths.get(MAIN_FOLDER, SHIP_FOLDER, TYPE_SHIP_2, "ship2_6.png").toString();

    public static final List<String> LIST_SHIP2 = List.of(STANDARD0, STANDARD1, STANDARD2, STANDARD3, STANDARD4, STANDARD5, STANDARD6);


    public static final String DELUXE = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship3.png").toString();
    public static final String NORMAL = Paths.get(MAIN_FOLDER,SHIP_FOLDER, "ship4.png").toString();
    public static final String ATOMIC = Paths.get(MAIN_FOLDER, SHIP_FOLDER, "ship5.png").toString();

}
