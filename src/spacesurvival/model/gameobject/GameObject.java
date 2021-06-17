package spacesurvival.model.gameobject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import spacesurvival.model.common.P2d;
import spacesurvival.model.Animation;
import spacesurvival.model.EngineImage;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.model.World;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;


public abstract class GameObject {
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
        this.setTransform(position);
        this.setEffectSounds(new LinkedList<>());
    }

    public void setPause(final boolean isPause) {
        this.body.setPause(isPause);
        this.effect.setPause(isPause);
    }

    public void stopAnimation() {
        this.body.setAnimating(false);
        this.effect.setAnimating(false);
    }
    
    public Image getImgBody() {
        return this.body.getImage();
    }
    
    public Image getImgEffect() {
        return this.effect.getImage();
    }

    public void setAnimation(final List<String> animation) {
        this.body.setListPath(animation);
    }

    public void setAnimationEffect(final List<String> animation) {
        this.effect.setListPath(animation);
    }

	
    public List<SoundPath> getEffectSounds() {
        return this.effectSounds;
    }

    public void setEffectSounds(final List<SoundPath> effectSounds) {
        this.effectSounds = effectSounds;
    }
	
    public void pushEffect(final SoundPath soundEffect) {
        this.effectSounds.add(soundEffect);
    }
	
    public final Optional<SoundPath> popEffect() {
        if (this.effectSounds.size() != 0) {
            final Optional<SoundPath> first = Optional.of(this.effectSounds.get(0));
            this.effectSounds.remove(0);
            return first;
        }
        return Optional.empty();
    }
	

    public final AffineTransform getTransform() {
        return this.transform;
    }

    public void setTransform(final P2d position) {
        this.transform = new AffineTransform();
        this.transform.translate(position.getX(), position.getY());
        this.boundingBox.setTransform(this.transform);
    }

    public void setTransform(final AffineTransform transform) {
        this.transform.setTransform(transform);
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

    public void setPosition(final P2d position) {
        final AffineTransform newTransform = new AffineTransform();
        newTransform.translate(position.getX(), position.getY());
        this.transform.setTransform(newTransform);
        this.boundingBox.setTransform(newTransform);
    }

    public final BoundingBox getBoundingBox() {
        return boundingBox;
    }


    public void setBoundingBox(final BoundingBox boundingBox) {
          this.boundingBox = boundingBox;
    }

    public void setEngineImage(final EngineImage engineImage) {
        this.body.setBody(engineImage);
    }


    public final PhysicsComponent getPhys() {
        return phys;
    }

    public void setPhys(final PhysicsComponent phys) {
        this.phys = phys;
    }
	

    public void updatePhysics(final World w){
        phys.update(this, w);
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
        return "GameObject [transform=" + transform + ", boundingBox=" + boundingBox
                + ", phys=" + phys + ", body=" + body + ", effect=" + effect + ", effectSounds=" + effectSounds + "]";
    }

}
