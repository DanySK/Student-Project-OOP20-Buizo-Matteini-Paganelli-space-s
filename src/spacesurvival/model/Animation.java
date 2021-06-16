package spacesurvival.model;

import java.util.ArrayList;
import java.util.List;

public class Animation extends Thread {

    private final List<String> listPath;
    private boolean isAnimating;
    private boolean isPause;
    private EngineImage body;

    public Animation(final EngineImage body) {
        this.listPath = new ArrayList<>();
        this.isAnimating = true;
        this.isPause = false;
        this.body = body;
    }

    public final EngineImage getBody() {
        return this.body;
    }

    public final List<String> getListPath() {
        return this.listPath;
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    public final boolean isPause() {
        return this.isPause;
    }


    public final void setBody(final EngineImage body) {
        this.body = body;
    }

    public final void setListPath(final List<String> listPath) {
        this.listPath.clear();
        this.listPath.addAll(listPath);
    }

    public final void setAnimating(final boolean isAnimating) {
        this.isAnimating = isAnimating;
    }

    public final void setPause(final boolean isPause) {
        this.isPause = isPause;
    }

    @Override
    public final void run() {
        int ind = 0;
        while (this.isAnimating) {
            if (!this.isPause && !this.listPath.isEmpty()) {
                ind = ind + 1 > this.listPath.size() ? 0 : ind;
                this.body.setPath(this.listPath.get(ind++));
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    @Override
    public String toString() {
        return "Animation [listPath=" + listPath + ", isAnimating=" + isAnimating + ", isPause=" + isPause + ", body="
                + body + "]";
    }
}
