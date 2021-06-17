package spacesurvival.utilities.gameobject;

import spacesurvival.model.common.V2d;

public final class VelocityUtils {

    private VelocityUtils() {
    }

    public static final int SPACESHIP_STARTING_VEL = 5;
	public static final int SPACESHIP_VELOCITY = 1;
	public static final int SPACESHIP_MAX_VELOCITY = 25;
	public static final int BULLET_VELOCITY = 20;
	
    public static final V2d SPACESHIP_VEL = new V2d(0, 0);
    public static final V2d ASTEROID_VEL = new V2d(5, 0);
    public static final V2d CHASE_ENEMY_VEL = new V2d(0,-3);
    public static final V2d FIRE_ENEMY_VEL = new V2d();
    public static final V2d BOSS_VEL = new V2d(0, 0);
    public static final V2d BULLET_VEL = new V2d(0, -40);
    public static final V2d NO_VEL = new V2d(0, 0);
	

}
