package spacesurvival.utilities.path.animation;

import java.nio.file.Paths;
import java.util.List;

import spacesurvival.utilities.path.MainFolder;

public class AnimationShip {

    public static final String SHIP_FOLDER = "spaceship";

    public static final String TYPE_SHIP_1 = "ship1";
    public static final String TYPE_SHIP_2 = "ship2";
    public static final String TYPE_SHIP_3 = "ship3";
    public static final String TYPE_SHIP_4 = "ship4";
    public static final String TYPE_SHIP_5 = "ship5";

    public static final String SPECIAL0 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_1, "ship1.png").toString();
    public static final String SPECIAL1 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_1, "ship1_1.png").toString();
    public static final String SPECIAL2 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_1, "ship1_2.png").toString();
    public static final String SPECIAL3 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_1, "ship1_3.png").toString();
    public static final String SPECIAL4 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_1, "ship1_4.png").toString();

    public static final List<String> LIST_SHIP1 = List.of(SPECIAL0, SPECIAL1, SPECIAL2, SPECIAL3, SPECIAL4);


    public static final String STANDARD0 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2.png").toString();
    public static final String STANDARD1 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2_1.png").toString();
    public static final String STANDARD2 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2_2.png").toString();
    public static final String STANDARD3 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2_3.png").toString();
    public static final String STANDARD4 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2_4.png").toString();
    public static final String STANDARD5 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2_5.png").toString();
    public static final String STANDARD6 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_2, "ship2_6.png").toString();

    public static final List<String> LIST_SHIP2 = List.of(STANDARD0, STANDARD1, STANDARD2, STANDARD3, STANDARD4, STANDARD5, STANDARD6);


    public static final String DELUXE0 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3.png").toString();
    public static final String DELUXE1 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_1.png").toString();
    public static final String DELUXE2 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_2.png").toString();
    public static final String DELUXE3 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_3.png").toString();
    public static final String DELUXE4 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_4.png").toString();
    public static final String DELUXE5 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_5.png").toString();
    public static final String DELUXE6 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_6.png").toString();
    public static final String DELUXE7 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_3, "ship3_7.png").toString();

    public static final List<String> LIST_SHIP3 = List.of(DELUXE0, DELUXE1, DELUXE2, DELUXE3, DELUXE4, DELUXE5, DELUXE6, DELUXE7);


    public static final String NORMAL0 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4.png").toString();
    public static final String NORMAL1 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4_1.png").toString();
    public static final String NORMAL2 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4_2.png").toString();
    public static final String NORMAL3 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4_3.png").toString();
    public static final String NORMAL4 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4_4.png").toString();
    public static final String NORMAL5 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4_5.png").toString();
    public static final String NORMAL6 = Paths.get(MainFolder.GAME_OBJECT,SHIP_FOLDER, TYPE_SHIP_4, "ship4_6.png").toString();

    public static final List<String> LIST_SHIP4 = List.of(NORMAL0, NORMAL1, NORMAL2, NORMAL3, NORMAL4, NORMAL5, NORMAL6);


    public static final String ATOMIC0 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_5, "ship5.png").toString();
    public static final String ATOMIC1 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_5, "ship5_1.png").toString();
    public static final String ATOMIC2 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_5, "ship5_2.png").toString();
    public static final String ATOMIC3 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_5, "ship5_3.png").toString();
    public static final String ATOMIC4 = Paths.get(MainFolder.GAME_OBJECT, SHIP_FOLDER, TYPE_SHIP_5, "ship5_4.png").toString();

    public static final List<String> LIST_SHIP5 = List.of(ATOMIC0, ATOMIC1, ATOMIC2, ATOMIC3, ATOMIC4);

}
