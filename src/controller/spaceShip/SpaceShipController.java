package controller.spaceShip;

import model.spaceShip.SpaceShipSingleton;
import view.spaceShip.SpaceShipView;

public class SpaceShipController {

    private SpaceShipSingleton spaceShipModel;
    private SpaceShipView spaceShipView;
    
    public SpaceShipController(final SpaceShipSingleton spaceShipModel, final SpaceShipView spaceShipView) {
        this.spaceShipModel = spaceShipModel;
        this.spaceShipView = spaceShipView;
    }

    
    public void main(String[] args){
    
        spaceShipModel = SpaceShipSingleton.getSpaceShip();
        
        spaceShipView = new SpaceShipView(spaceShipModel.getSpaceImagePath(), spaceShipModel.getPosition());
        
        spaceShipView.show();
  
    }
}