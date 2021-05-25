package spaceSurvival.utilities;

public enum SoundPath {
	MENU_SOUND	("sounds/menu.wav"),
	GAME_SOUND	("sounds/game.wav"),
	SHOOT		("sounds/shoot.wav"),
	LIFE_UP		("sounds/lifeUp.wav"),
	LIFE_DOWN	("sounds/lifeDown.wav"), 
	PERK		("sounds/perk.wav"),
	WALL_COLLISION ("sounds/wallCollision.wav");
//	START_GAME	("sounds/startGame.wav"),
//	END_GAME	("sounds/endGame.wav"),
//	METEOR_EXPL	("sounds/meteorExpl.wav"),
//	ENEMY_EXPL	("sounds/enemyExpl.wav"),
//	SHIP_EXPL	("sounds/shipExpl.wav"),

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