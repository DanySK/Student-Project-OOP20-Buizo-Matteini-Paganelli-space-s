package spacesurvival.view.game.utilities.commandlife.command;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.view.game.utilities.commandlife.CommandLife;

public class LifeChase implements CommandLife {

    @Override
    public int execute(final GameObject gameObject) {
        final int life = ((MainObject) gameObject).getLife();
        final int width = (int)gameObject.getWidth();
        
        return (int) ((life * width) / GameObjectUtils.CHASE_ENEMY_LIFE);
    }

}
