package core;

import common.P2d;
import common.V2d;
import physics.*;
import CommandProva.graphics.*;
import CommandProva.input.*;
import CommandProva.model.*;

public class GameFactory {

	static private GameFactory instance;
	
	static public GameFactory getInstance(){
		if (instance == null){
			instance = new GameFactory();
		}
		return instance;
	}
	
	public GameObject createBall(P2d pos, double radius, V2d vel){
		return new GameObject(GameObject.Type.BALL, pos, vel, new PerkBoundingBox(new P2d(pos.x, pos.y), radius),
				new PlayerInputComponentWithAcc(),
				new BallGraphicsComponent(),
				new ShipPhysicsComponent());
	}
	
	public GameObject createPickUpObject(P2d pos, double edge){
		return new GameObject(GameObject.Type.PICKABLE_OBJ, pos, new V2d(0,0), new PerkBoundingBox(new P2d(pos.x, pos.y), edge/2),
				new NullInputComponent(),
				new PickUpObjGraphicsComponent(),
				new PickUpLifePhysicsComponent());
	}
}
