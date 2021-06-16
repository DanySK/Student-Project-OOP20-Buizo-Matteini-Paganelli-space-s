package spacesurvival.model.gameobject;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import spacesurvival.model.EngineMalaLoop;
import spacesurvival.model.common.P2d;
import spacesurvival.model.Animation;
import spacesurvival.model.EngineImage;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.model.World;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;

public abstract class GameObject {

    private P2d position;
    private AffineTransform transform;
    private BoundingBox boundingBox;
    private PhysicsComponent phys;

    private final Animation body;
    private final Animation effect;

    private List<SoundPath> effectSounds;

    public GameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                      final PhysicsComponent phys) {
	
        this.body = new Animation(engineImage);
        this.effect = new Animation(EngineImage.getTransparentEngineImage(engineImage));

        this.body.start();
        this.effect.start();

        this.boundingBox = bb;
        this.phys = phys;
        this.position = position;
        this.setEffectSounds(new LinkedList<>());
        this.transform = new AffineTransform();
    }

    public final void setPause(final boolean isPause) {
        this.body.setPause(isPause);
        this.effect.setPause(isPause);
    }

    public final void stopAnimation() {
        this.body.setAnimating(false);
        this.effect.setAnimating(false);
    }

    public final void setAnimation(final List<String> animation) {
        this.body.setListPath(animation);
    }

    public final void setAnimationEffect(final List<String> animation) {
        this.effect.setListPath(animation);
    }

	
    public final List<SoundPath> getEffectSounds() {
        return this.effectSounds;
    }

    public final void setEffectSounds(final List<SoundPath> effectSounds) {
        this.effectSounds = effectSounds;
    }
	
    public final void pushEffect(final SoundPath soundEffect) {
        this.effectSounds.add(soundEffect);
    }
	
    public final Optional<SoundPath> popEffect() {
//		Optional<SoundPath> first = Optional.of(this.effectSounds.get(0))
//		if(!first.equals(Optional.empty())) {
//			this.effectSounds.remove(0);
//		}	
        if (this.effectSounds.size() != 0) {
            Optional<SoundPath> first = Optional.of(this.effectSounds.get(0));
            this.effectSounds.remove(0);
            return first;

        }
        return Optional.empty();
    }
	

    public final AffineTransform getTransform() {
        return this.transform;
    }

    public final void setTransform(final AffineTransform transform) {
        this.transform.setTransform(transform);
        //RectBoundingBox rectBB = (RectBoundingBox) this.getBoundingBox();
        //rectBB.setTransform(transform);
        this.position.x = transform.getTranslateX();
        this.position.y = transform.getTranslateY();

        this.boundingBox.setTransform(transform);
    }
	
	
    public final EngineImage getEngineImage() {
        return this.body.getBody();
    }

    public final EngineImage getEngineEffect() {
        return this.effect.getBody();
    }

    public final P2d getPosition() {
        return new P2d(this.transform.getTranslateX(), this.getTransform().getTranslateY());
    }

    public final void setPosition(final P2d position) {
        final AffineTransform newTransform = new AffineTransform();
        newTransform.translate(position.getX(), position.getY());
        this.transform.setTransform(newTransform);
        this.boundingBox.setTransform(newTransform);
    }

    public final BoundingBox getBoundingBox() {
        return boundingBox;
    }


    public final void setBoundingBox(final BoundingBox boundingBox) {
          this.boundingBox = boundingBox;
    }

    public final void setEngineImage(final EngineImage engineImage) {
        this.body.setBody(engineImage);
    }


    public final PhysicsComponent getPhys() {
        return phys;
    }

    public final void setPhys(final PhysicsComponent phys) {
        this.phys = phys;
    }
	
    public final void updatePhysics(final int dt, final World w) {
        phys.update(dt, this, w);
    }
	
    public final Dimension getSize() {
        return this.body.getBody().getSize();
    }
	
    public final double getWidth() {
        return this.getEngineImage().getSize().getWidth();
    }
	
    public final double getHeight() {
        return this.getEngineImage().getSize().getHeight();
    }

    public final List<String> getAnimation() {
        return this.body.getListPath();
    }

    @Override
    public String toString() {
        return "GameObject [position=" + position + ", transform=" + transform + ", boundingBox=" + boundingBox
                + ", phys=" + phys + ", body=" + body + ", effect=" + effect + ", effectSounds=" + effectSounds + "]";
    }

}
