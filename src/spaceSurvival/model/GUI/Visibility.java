package spaceSurvival.model.GUI;

public enum Visibility {
    VISIBLE(true),
    HIDDEN(false);

    private final boolean state;

    private Visibility(final boolean state){
        this.state = state;
    }

    public boolean isVisible() {
        return this.state;
    }

    @Override
    public String toString() {
        return "Visibility{" +
                "state=" + state +
                '}';
    }
}
