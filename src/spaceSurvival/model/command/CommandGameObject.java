package spacesurvival.model.command;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public interface CommandGameObject {
    void execute(SpaceShipSingleton object);
}