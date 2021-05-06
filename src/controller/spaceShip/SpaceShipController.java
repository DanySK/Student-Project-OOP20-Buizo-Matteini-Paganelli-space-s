package controller.spaceShip;

import view.spaceShip.SpaceShipView;

import java.awt.event.KeyListener;

import model.gameObject.spaceShip.SpaceShipSingleton;

public class SpaceShipController {

    private final SpaceShipSingleton spaceShipModel;
    private final SpaceShipView spaceShipView;
    
    public SpaceShipController(final SpaceShipSingleton spaceShipModel, final SpaceShipView spaceShipView) {
        this.spaceShipModel = spaceShipModel;
        this.spaceShipView = spaceShipView;
        this.init();
    }

    private void init() {

//        this.spaceShipView.setImage(this.spaceShipModel.getPath());
//
//        this.spaceShipView.setScaleOfRespect(this.spaceShipModel.getScaleOf(), this.spaceShipModel.getRespectTo());

//		this.spaceShipView.setPosition(
//				this.spaceShipModel.getPosition());
	}

	public void setKeyListenerSpaceship(final KeyListener keyListener){
        this.spaceShipView.addKeyListener(keyListener);
    }

    public SpaceShipView getSPaceShipView(){
        return this.spaceShipView;
    }

}