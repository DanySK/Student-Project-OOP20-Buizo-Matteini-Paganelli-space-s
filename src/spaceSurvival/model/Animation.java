package spaceSurvival.model;

import java.util.ArrayList;
import java.util.List;

public class Animation extends Thread{
    private final List<String> animation;
    private boolean isAnimation;
    private EngineImage body;

    public Animation(final EngineImage body){
        this.animation = new ArrayList<>();
        this.isAnimation = false;
        this.body = body;
    }

    public EngineImage getBody() {
        return this.body;
    }

    public List<String> getAnimation() {
        return this.animation;
    }

    public void setBody(EngineImage body) {
        this.body = body;
    }

    public void setAnimation(final List<String> animation){
        this.animation.clear();
        this.animation.addAll(animation);
    }

    public boolean isAnimation() {
        return this.isAnimation;
    }

    public void setAnimation(final boolean animation) {
        this.isAnimation = animation;
    }

    @Override
    public void run() {
        int ind = 0;
        while (true) {
            if(this.isAnimation && !this.animation.isEmpty()) {
                this.body.setPath(this.animation.get(ind));
                ind = ind + 1 > this.animation.size() ? 0 : ind + 1;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
