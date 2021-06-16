package spacesurvival.model.command.commandInterfaces;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public interface CommandGameObject {
    void execute(SpaceShipSingleton object);
}