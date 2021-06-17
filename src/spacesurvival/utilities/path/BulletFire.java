package spacesurvival.utilities.path;

import java.nio.file.Path;

public class BulletFire {
    
    public static final String MAIN_FOLDER = "shutBullet";
    
    public static final String TYPE_HUD = "vertical";
    
    public static final String FIRE = Path.of(MAIN_FOLDER, TYPE_HUD, "fire.png").toString();
    public static final String ICE = Path.of(MAIN_FOLDER, TYPE_HUD, "ice.png").toString();
    public static final String ELECTRIC = Path.of(MAIN_FOLDER, TYPE_HUD, "electric.png").toString();
    public static final String NORMAL = Path.of(MAIN_FOLDER, TYPE_HUD, "normal.png").toString();

}
