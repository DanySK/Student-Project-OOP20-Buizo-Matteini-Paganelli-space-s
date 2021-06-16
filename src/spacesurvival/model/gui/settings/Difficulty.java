package spacesurvival.model.gui.settings;

public enum Difficulty {
    //dfficolta ancora da associale alla difficolta reale del gioco
    EASY("Easy", 30),
    MEDIUM("Medium", 50),
    HARD("Hard",70);

    private String name;

    private int difficult;

    private Difficulty(final String name, final int difficult){
        this.name = name;
        this.difficult = difficult;
    }

    public String getName(){
        return this.name;
    }



    @Override
    public String toString() {
        return "Difficulty{" +
                "name='" + name + '\'' +
                ", difficult=" + difficult +
                '}';
    }
}
