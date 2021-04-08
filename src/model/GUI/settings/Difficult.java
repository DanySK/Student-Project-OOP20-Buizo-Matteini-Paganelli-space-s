package model.GUI.settings;

public enum Difficult {
    EASY("Easy", 30),
    MEDIUM("Medium", 50),
    HARD("Hard",70);

    private String name;

    private int difficult;

    private Difficult(final String name, final int difficult){
        this.name = name;
        this.difficult = difficult;
    }

    public String getName(){
        return this.name;
    }
}
