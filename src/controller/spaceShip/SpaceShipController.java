package controller.spaceShip;

import model.spaceShip.SpaceShipSingleton;
import view.spaceShip.SpaceShipView;

public class SpaceShipController {

    private static SpaceShipSingleton spaceShipModel;
    private static SpaceShipView spaceShipView;
    
    public SpaceShipController(final SpaceShipSingleton spaceShipModel, final SpaceShipView spaceShipView) {
        this.spaceShipModel = spaceShipModel;
        this.spaceShipView = spaceShipView;
    }

    
    public static void main(String[] args){
    
        spaceShipModel = SpaceShipSingleton.getSpaceShip();        
        spaceShipView = new SpaceShipView(spaceShipModel.getSpaceImagePath(), spaceShipModel.getPosition());
        
        spaceShipModel.setDimension(spaceShipView.getShipImage().getSize());
        
        spaceShipView.show();
    }
}