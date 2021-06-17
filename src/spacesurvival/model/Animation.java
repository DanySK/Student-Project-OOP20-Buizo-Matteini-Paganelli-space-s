package spacesurvival.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import spacesurvival.utilities.ThreadUtils;

public class Animation extends Thread {
    private List<String> listPath;
    private boolean isAnimating;
    private boolean isPause;
    private EngineImage body;

    public Animation(final EngineImage body) {
        this.listPath = new ArrayList<>();
        this.isAnimating = true;
        this.isPause = false;
        this.body = body;
    }

    public EngineImage getBody() {
        return this.body;
    }

    public List<String> getListPath() {
        return this.listPath;
    }

    public boolean isAnimating() {
        return this.isAnimating;
    }

    public boolean isPause() {
        return this.isPause;
    }

    public Image getImage() {
        return this.body.getImage();
    }


    public void setBody(final EngineImage body) {
        this.body = body;
    }

    public void setListPath(final List<String> listPath) {
        this.listPath = listPath;
    }

    public void setAnimating(final boolean isAnimating) {
        this.isAnimating = isAnimating;
    }

    public void setPause(final boolean isPause) {
        this.isPause = isPause;
    }

    @Override
    public void run() {
        int ind = 0;
        long lastTime = System.currentTimeMillis();

        while (this.isAnimating) {
            long current = System.currentTimeMillis();
            if (!this.isPause && !this.listPath.isEmpty()) {
                ind = ind + 1 > this.listPath.size() ? 0 : ind;
                this.body.setPath(this.listPath.get(ind++));
            }

            ThreadUtils.sleep(100);
//            waitForNextFrame(current);
            lastTime = current;
        }
    }

   public void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < 60) {
            ThreadUtils.sleep(60 - dt);
        }
    }

    @Override
    public String toString() {
        return "Animation [listPath=" + listPath + ", isAnimating=" + isAnimating + ", isPause=" + isPause + ", body="
                + body + "]";
    }
}
