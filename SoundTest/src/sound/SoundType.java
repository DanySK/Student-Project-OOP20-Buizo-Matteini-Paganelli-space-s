package sound;

public enum SoundType {

	MENU_SOUND	("menuSound.wav"),
	GAME_SOUND	("gameSound.wav"),
	MOVEMENT	("movementSound.wav"),
	SHOOT		("shootSound.wav"),
	LIFE_UP		("lifeUpSound.wav"),
	LIFE_DOWN	("lifeDownSound.wav"),
	START_GAME	("startGameSound.wav"),
	END_GAME	("endGameSound.wav"),
	METEOR_EXPL	("meteorExplSound.wav"),
	ENEMY_EXPL	("enemyExplSound.wav"),
	SHIP_EXPL	("shipExplSound.wav"),
	PERK		("perkSound.wav");
	
	
	
	private final String path;
	
 
	SoundType(String path) {
		this.path = path;
	}
	
	public String getValue() {
		return this.path;
	}

}