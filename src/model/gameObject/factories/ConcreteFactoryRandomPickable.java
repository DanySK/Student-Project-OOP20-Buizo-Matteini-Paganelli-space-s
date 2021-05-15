package model.gameObject.factories;

import model.common.P2d;
import model.gameObject.AbstractGameObject;
import model.gameObject.EffectType;
import model.gameObject.GameObjectUtils;
import model.gameObject.PickableGameObject;
import model.image.EngineImage;
import utilities.pathImage.Icon;

public class ConcreteFactoryRandomPickable extends AbstractFactoryGameObject {

	public ConcreteFactoryRandomPickable() {
		super();
	}
	
	@Override
	public PickableGameObject createObject() {
		final EngineImage engineImage = new EngineImage(Icon.BULLET);
		final P2d point = GameObjectUtils.generateSpawnPoint(engineImage.getSize());
	 	final EffectType effectType = EffectType.randomEffect();
		
		return new PickableGameObject(engineImage, point, null, null, effectType);
	}

}
