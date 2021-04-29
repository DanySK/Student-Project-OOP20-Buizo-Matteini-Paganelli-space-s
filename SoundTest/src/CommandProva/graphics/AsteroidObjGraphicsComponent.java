package CommandProva.graphics;

import CommandProva.model.GameObject;

public class AsteroidObjGraphicsComponent implements GraphicsComponent {

	@Override
	public void update(GameObject obj, Graphics w) {
		w.drawPickableObj(obj);
	}

}
