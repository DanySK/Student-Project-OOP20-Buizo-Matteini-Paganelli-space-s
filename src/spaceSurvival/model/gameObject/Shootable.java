package spaceSurvival.model.gameObject;

import java.util.Optional;

import spaceSurvival.model.gameObject.weapon.Weapon;

public interface Shootable {
	void shot(Optional<Weapon> weapon);
}
