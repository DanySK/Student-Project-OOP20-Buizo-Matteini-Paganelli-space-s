package spacesurvival.model.GUI.scoreboard;

public enum NameScoreboardGUI {
    SEARCH_BUTTON("Search"),
    BACK_BUTTON("Back");

    private final String name;

    private NameScoreboardGUI(final String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
