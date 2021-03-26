package utilities;

public enum IdGUI {
    ID_MENU(0, "Menu"),
    ID_GAME(1, "Game"),
    ID_SETTING(2, "Settings"),
    ID_SCOREBOARD(3, "Scoreboard"),
    ID_HELP(4, "Help"),
    ID_QUIT(5, "Quit"),
    ID_PAUSE(6, "Pause"),
    ID_BACK(7, "Back");

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
