package spacesurvival.model.gui.settings;

public enum StateDifficult {
    ON(true),
    OFF(false);

    private final boolean difficult;

    private StateDifficult(final boolean difficult){
        this.difficult = difficult;
    }

    public boolean isDifficult() {
        return difficult;
    }

    @Override
    public String toString() {
        return "DifficultActive{" +
                "difficult=" + difficult + '}';
    }
}
