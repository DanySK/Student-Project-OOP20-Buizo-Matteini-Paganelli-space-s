package model.GUI.sound;

public enum StateSlider {
    ON(true, "icon/volumeON.png"),
    OFF(false, "icon/volumeOFF.png");

    private final boolean state;

    private final String path;

    private StateSlider(final boolean state, final String path){
        this.state = state;
        this.path = path;
    }

    public boolean isActive() {
        return this.state;
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public String toString() {
        return "StateSlider{" +
                "state=" + state +
                '}';
    }
}
