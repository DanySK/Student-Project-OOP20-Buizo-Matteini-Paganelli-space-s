package CommandProva.graphics;

import CommandProva.model.*;


public class ShipGraphicsComponent implements GraphicsComponent {

	@Override
	public void update(GameObject obj, Graphics g) {
		/*
		 * @TODO
		 * select the proper sprite according to the ship state
		 */
		g.drawBall(obj);
		
	}

}
