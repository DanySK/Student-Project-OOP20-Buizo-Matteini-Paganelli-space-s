package spacesurvival.utilities.path;

import java.nio.file.Paths;

public final class Weapon {

    /**
     * Path of fire weapon.
     */
    public static final String FIRE = Paths.get(MainFolder.BULLET_TYPE, "fire.png").toString();

    /**
     * Path of electric weapon.
     */
    public static final String ELECTRIC = Paths.get(MainFolder.BULLET_TYPE, "electric.png").toString();

    /**
     * Path of ice weapon.
     */
    public static final String ICE = Paths.get(MainFolder.BULLET_TYPE, "ice.png").toString();

    private Weapon() {

    }
}
