package spaceSurvival.utilities;

public enum SoundPath {
	MENU_SOUND	("sounds/menu.wav"),
	GAME_SOUND	("sounds/game.wav"),
	SHOOT		("sounds/mala.wav"),
	LIFE_UP		("sounds/lifeUp.wav"),
	LIFE_DOWN	("sounds/lifeDown.wav");
//	START_GAME	("sounds/startGame.wav"),
//	END_GAME	("sounds/endGame.wav"),
//	METEOR_EXPL	("sounds/meteorExpl.wav"),
//	ENEMY_EXPL	("sounds/enemyExpl.wav"),
//	SHIP_EXPL	("sounds/shipExpl.wav"),
//	PERK		("sounds/perk.wav");
//	
//	MOVEMENT	("sounds/movement.wav"),

	private final String path;


	SoundPath(String path) {
		this.path = path;
	}

	public String getValue() {
		return this.path;
	}

}