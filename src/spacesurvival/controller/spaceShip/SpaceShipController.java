package spacesurvival.controller.spaceShip;

import spacesurvival.model.gameObject.mainGameObject.SpaceShipSingleton;


public class SpaceShipController {

    private final SpaceShipSingleton spaceShipModel;

    public SpaceShipController(final SpaceShipSingleton spaceShipModel) {
        this.spaceShipModel = spaceShipModel;
        this.init();
    }

    private void init() {

//        this.spaceShipView.setImage(this.spaceShipModel.getPath());
//
//        this.spaceShipView.setScaleOfRespect(this.spaceShipModel.getScaleOf(), this.spaceShipModel.getRespectTo());

//		this.spaceShipView.setPosition(
//				this.spaceShipModel.getPosition());
	}

	public SpaceShipSingleton getSpaceShipModel() {
		return spaceShipModel;
	}

}