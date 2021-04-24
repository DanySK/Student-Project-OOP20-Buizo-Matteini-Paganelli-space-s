package CommandProva;

import core.GameEngine;

public class SpaceShipGame {

	public static void main(String[] args) {
		GameEngine engine = new GameEngine();
		engine.initGame();
		engine.mainLoop();
	}

}
