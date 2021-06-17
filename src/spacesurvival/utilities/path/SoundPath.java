package spacesurvival.utilities.path;

import spacesurvival.utilities.SoundType;
import java.nio.file.Paths;

public enum SoundPath {
    /**
     * Path relative to the menu sound, loop type.
     */
    MENU_SOUND(Paths.get(MainFolder.SOUND, "menu.wav").toString(), SoundType.LOOP),
    /**
     * Path relative to the game sound, loop type.
     */
    GAME_SOUND(Paths.get(MainFolder.SOUND, "game.wav").toString(), SoundType.LOOP),
    /**
     * Path relative to the shoot sound, effect type.
     */
    SHOOT(Paths.get(MainFolder.SOUND, "shoot.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the enemy shoot sound, effect type.
     */
    ENEMY_SHOOT(Paths.get(MainFolder.SOUND, "enemyShoot.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the life up sound, effect type.
     */
    LIFE_UP(Paths.get(MainFolder.SOUND, "lifeUp.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the life down sound, effect type.
     */
    LIFE_DOWN(Paths.get(MainFolder.SOUND, "lifeDown.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the perk sound, effect type.
     */
    PERK(Paths.get(MainFolder.SOUND, "perk.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the asteroid explosion sound, effect type.
     */
    ASTEROID_EXPL(Paths.get(MainFolder.SOUND, "asteroidExpl.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the enemy explosion sound, effect type.
     */
    ENEMY_EXPL(Paths.get(MainFolder.SOUND, "enemyExpl.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the ship explosion sound, effect type.
     */
    SHIP_EXPL(Paths.get(MainFolder.SOUND, "shipExpl.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the boss explosion sound, effect type.
     */
    BOSS_EXPL(Paths.get(MainFolder.SOUND, "bossExpl.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the wall collision sound, effect type.
     */
    WALL_COLLISION(Paths.get(MainFolder.SOUND, "wallCollision.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the level up sound, effect type.
     */
    LEVEL_UP(Paths.get(MainFolder.SOUND, "levelUp.wav").toString(), SoundType.EFFECT),
    /**
     * Path relative to the game over sound, effect type.
     */
    GAME_OVER(Paths.get(MainFolder.SOUND, "gameOver.wav").toString(), SoundType.EFFECT);


    private final String path;
    private final SoundType type;


    /**
     * Type of command to pass to the playSound method to play the selected sound.
     * 
     * @param path string represents the path of the file
     * @param type SoundType represents the type of sound, loop or effect
     */
    SoundPath(final String path, final SoundType type) {
        this.path = path;
        this.type = type;
    }

    /**
     * Return the path of the current SoundPath.
     * 
     * @return the path to the sound file
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Return the type of the current SoundPath.
     * 
     * @return the type of the sound
     */
    public SoundType getType() {
        return this.type;
    }

}
