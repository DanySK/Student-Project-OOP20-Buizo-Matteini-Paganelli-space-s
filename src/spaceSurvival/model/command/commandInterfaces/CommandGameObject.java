package spaceSurvival.model.command.commandInterfaces;

import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;

public interface CommandGameObject {
    void execute(SpaceShipSingleton object);
}