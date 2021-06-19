package spacesurvival.utilities.path.bullet;

import spacesurvival.utilities.path.MainFolder;

import java.nio.file.Path;

public final class BulletFire {
    /** 
     * Path of hud bullet.
     */
    public static final String TYPE_HUD = "vertical";

    /** 
     * Path of fire hud bullet.
     */
    public static final String FIRE = Path.of(MainFolder.BULLET, TYPE_HUD, "fire.png").toString();

    /** 
     * Path of ice hud bullet.
     */
    public static final String ICE = Path.of(MainFolder.BULLET, TYPE_HUD, "ice.png").toString();

    /** 
     * Path of electric hud bullet.
     */
    public static final String ELECTRIC = Path.of(MainFolder.BULLET, TYPE_HUD, "electric.png").toString();

    /** 
     * Path of fire normal bullet.
     */
    public static final String NORMAL = Path.of(MainFolder.BULLET, TYPE_HUD, "normal.png").toString();

    private BulletFire() {

    }
}
