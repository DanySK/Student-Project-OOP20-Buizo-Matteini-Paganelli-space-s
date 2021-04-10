package utilities;

public enum IdGUI {
    ID_MENU(0, "Menu"),
    ID_GAME(1, "Game"),
    ID_SETTING(2, "Settings"),
    ID_SCOREBOARD(3, "Scoreboard"),
    ID_SOUND(4, "Sound"),
    ID_HELP(5, "Help"),
    ID_QUIT(6, "Quit"),
    ID_PAUSE(7, "Pause"),
    ID_BACK(8, "Back");

    private final int id;
    private final String name;

    private IdGUI(final int id, final String name){
        this.id = id;
        this.name = name;
    }

    public int getIdInt(){
        return this.id;
    }

    public String getIdName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "IdGUI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
