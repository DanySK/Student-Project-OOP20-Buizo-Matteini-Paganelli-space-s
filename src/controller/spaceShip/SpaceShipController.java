package controller.spaceShip;

import model.spaceShip.SpaceShipSingleton;
import view.spaceShip.SpaceShipView;

public class SpaceShipController {

    private final SpaceShipSingleton spaceShipModel;
    private final SpaceShipView spaceShipView;
    
    public SpaceShipController(final SpaceShipSingleton spaceShipModel, final SpaceShipView spaceShipView) {
        this.spaceShipModel = spaceShipModel;
        this.spaceShipView = spaceShipView;
        init();
    }

    private void init() {
		this.spaceShipView.setPosition(
				this.spaceShipModel.getPosition());
		this.spaceShipView.setDimension(
				this.spaceShipModel.getDimension());
	}
}