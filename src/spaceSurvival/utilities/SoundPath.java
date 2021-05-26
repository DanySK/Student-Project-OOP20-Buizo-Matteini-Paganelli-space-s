package spaceSurvival.utilities;

import java.nio.file.Paths;

public enum SoundPath {
	MENU_SOUND		(Paths.get("sounds", "menu.wav").toString()),
	GAME_SOUND		(Paths.get("sounds", "game.wav").toString()),
	SHOOT			(Paths.get("sounds", "shoot.wav").toString()),
	ENEMY_SHOOT		(Paths.get("sounds", "enemyShoot.wav").toString()),
	LIFE_UP			(Paths.get("sounds", "lifeUp.wav").toString()),
	LIFE_DOWN		(Paths.get("sounds", "lifeDown.wav").toString()),
	PERK			(Paths.get("sounds", "perk.wav").toString()),
	ASTEROID_EXPL	(Paths.get("sounds", "asteroidExpl.wav").toString()),
	ENEMY_EXPL		(Paths.get("sounds", "enemyExpl.wav").toString()),
	SHIP_EXPL		(Paths.get("sounds", "shipExpl.wav").toString()),
	BOSS_EXPL		(Paths.get("sounds", "bossExpl.wav").toString()),
	WALL_COLLISION  (Paths.get("sounds", "wallCollision.wav").toString());
//	START_GAME	("sounds/startGame.wav"),
//	END_GAME	("sounds/endGame.wav"),
//	LEVEL_UP		("sounds/levelUp.wav"),
//	MOVEMENT	("sounds/movement.wav"),
//	GAME_OVER   ("sounds/movement.wav");

	private final String path;


	SoundPath(String path) {
		this.path = path;
	}

	public String getValue() {
		return this.path;
	}

}