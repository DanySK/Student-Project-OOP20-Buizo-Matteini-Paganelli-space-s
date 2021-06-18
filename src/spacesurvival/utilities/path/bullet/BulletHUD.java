package spacesurvival.utilities.path.bullet;

import spacesurvival.utilities.path.MainFolder;

import java.nio.file.Path;

public class BulletHUD {
    
    /** 
     * Path to type folder.
     */
    public static final String TYPE_HUD = "oblique";
    
    /** 
     * Path of icon fire bullet in HUD.
     */
    public static final String FIRE = Path.of(MainFolder.BULLET, TYPE_HUD, "fire.png").toString();
    
    /** 
     * Path of icon ice bullet in HUD.
     */
    public static final String ICE = Path.of(MainFolder.BULLET, TYPE_HUD, "ice.png").toString();
    
    /** 
     * Path of icon electric bullet in HUD.
     */
    public static final String ELECTRIC = Path.of(MainFolder.BULLET, TYPE_HUD, "electric.png").toString();
    
    /** 
     * Path of icon normal bullet in HUD.
     */
    public static final String NORMAL = Path.of(MainFolder.BULLET, TYPE_HUD, "normal.png").toString();
    
}
