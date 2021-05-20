package spaceSurvival.model.GUI.settings;

public enum DifficultActive {
    ON(true),
    OFF(false);

    private final boolean difficult;

    private DifficultActive(final boolean difficult){
        this.difficult = difficult;
    }

    public boolean isDifficult() {
        return difficult;
    }

    @Override
    public String toString() {
        return "DifficultActive{" +
                "difficult=" + difficult +
                '}';
    }
}
