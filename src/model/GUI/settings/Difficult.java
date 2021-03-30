package model.GUI.settings;

public enum Difficult {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard");

    private String name;

    private Difficult(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
