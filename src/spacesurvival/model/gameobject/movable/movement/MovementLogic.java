package spacesurvival.model.gameobject.movable.movement;

import spacesurvival.model.gameobject.movable.MovableObject;

/**
 * Implements the moving logic based on the game object.
 */
public interface MovementLogic {

    /**
     * Move the object in the next point based on its velocity and direction.
     * 
     * @param movableObject
     */
    void move(MovableObject movableObject);

    /**
     * Starts the game object move if move method called by the main game loop.
     * It can be implemented to make possible change directions or other automatic stuffs.
     * 
     * @param movableObject object which has to initiate moving
     */
    default void startMoving(MovableObject movableObject) {
        movableObject.setMoving(true);
    }

    /**
     * Stop the game object move.
     * It can be implemented to make more stuffs after stop moving.
     * 
     * @param movableObject object which has to initiate moving
     */
    default void stopMoving(MovableObject movableObject) {
        movableObject.setMoving(false);
    }
}
