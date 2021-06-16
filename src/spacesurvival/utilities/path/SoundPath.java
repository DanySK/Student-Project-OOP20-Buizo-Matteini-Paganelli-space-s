package spacesurvival.utilities.path;

import spacesurvival.utilities.SoundType;

import java.nio.file.Paths;



public enum SoundPath {
	MENU_SOUND	     (Paths.get("sounds", "menu.wav").  toString(),         SoundType.LOOP),
	GAME_SOUND	     (Paths.get("sounds", "game.wav").toString(),           SoundType.LOOP),
	SHOOT		     (Paths.get("sounds", "shoot.wav").toString(),          SoundType.EFFECT),
	ENEMY_SHOOT	     (Paths.get("sounds", "enemyShoot.wav").toString(),     SoundType.EFFECT),
	LIFE_UP		     (Paths.get("sounds", "lifeUp.wav").toString(),         SoundType.EFFECT),
	LIFE_DOWN	     (Paths.get("sounds", "lifeDown.wav").toString(), 	    SoundType.EFFECT),
	PERK		     (Paths.get("sounds", "perk.wav").toString(), 		    SoundType.EFFECT),
	ASTEROID_EXPL    (Paths.get("sounds", "asteroidExpl.wav").toString(),   SoundType.EFFECT),
	ENEMY_EXPL	     (Paths.get("sounds", "enemyExpl.wav").toString(), 		SoundType.EFFECT),
	SHIP_EXPL	     (Paths.get("sounds", "shipExpl.wav").toString(), 		SoundType.EFFECT),
	BOSS_EXPL	     (Paths.get("sounds", "bossExpl.wav").toString(), 		SoundType.EFFECT),
	WALL_COLLISION   (Paths.get("sounds", "wallCollision.wav").toString(),  SoundType.EFFECT);
//	START_GAME	("sounds/startGame.wav"),
//	END_GAME	("sounds/endGame.wav"),
//	LEVEL_UP		("sounds/levelUp.wav"),
//	MOVEMENT	("sounds/movement.wav"),
//	GAME_OVER   ("sounds/movement.wav");

	private final String path;
	private final SoundType type;


	SoundPath(String path, SoundType type) {
		this.path = path;
		this.type = type;
	}

	public String getPath() {
		return this.path;
	}
	
	SoundType getType() {
		return this.type;
	}

}
