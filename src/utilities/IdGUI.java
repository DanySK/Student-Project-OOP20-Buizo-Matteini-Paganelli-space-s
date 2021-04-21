package utilities;

public enum IdGUI {
    ID_MENU(0, "Menu", SoundType.MENU_SOUND),
    ID_GAME(1, "Game", SoundType.GAME_SOUND),
    ID_SETTING(2, "Settings", SoundType.MENU_SOUND),
    ID_SCOREBOARD(3, "Scoreboard", SoundType.MENU_SOUND),
    ID_SOUND(4, "Sound", SoundType.MENU_SOUND),
    ID_HELP(5, "Help", SoundType.MENU_SOUND),
    ID_QUIT(6, "Quit", SoundType.MENU_SOUND),
    ID_PAUSE(7, "Pause", SoundType.MENU_SOUND),
    ID_BACK(8, "Back", SoundType.MENU_SOUND);

    private final int id;
    private final String name;
    private final SoundType sound;

    private IdGUI(final int id, final String name, final SoundType sound){
        this.id = id;
        this.name = name;
        this.sound = sound;
    }

    public int getIdInt(){
        return this.id;
    }

    public String getIdName(){
        return this.name;
    }

    public SoundType getSound() {
        return this.sound;
    }

    @Override
    public String toString() {
        return "IdGUI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
