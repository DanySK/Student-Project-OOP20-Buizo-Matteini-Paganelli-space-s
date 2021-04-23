package controller.spaceShip;

import model.spaceShip.SpaceShipSingleton;
import view.spaceShip.SpaceShipView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class SpaceShipController {

    private final SpaceShipSingleton spaceShipModel;
    private final SpaceShipView spaceShipView;
    
    public SpaceShipController(final SpaceShipSingleton spaceShipModel, final SpaceShipView spaceShipView) {
        this.spaceShipModel = spaceShipModel;
        this.spaceShipView = spaceShipView;
        init();
    }

    private void init() {
        this.spaceShipView.setIconImage(this.spaceShipModel.getSpaceImageEngine().getPath());

        this.spaceShipView.setDimension(
                this.spaceShipModel.getDimension());

		this.spaceShipView.setPosition(
				this.spaceShipModel.getPosition());
	}

	public void setKeyListenerSpaceship(final KeyListener keyListener){
        this.spaceShipView.addKeyListener(keyListener);
    }

    public SpaceShipView getSPaceShipView(){
        return this.spaceShipView;
    }

}