package utilities;

public enum IdGUI {
    ID_MENU(0, "Menu", SoundPath.MENU_SOUND),
    ID_GAME(1, "Game", SoundPath.GAME_SOUND),
    ID_SETTING(2, "Settings", SoundPath.MENU_SOUND),
    ID_SCOREBOARD(3, "Scoreboard", SoundPath.MENU_SOUND),
    ID_SOUND(4, "Sound", SoundPath.MENU_SOUND),
    ID_HELP(5, "Help", SoundPath.MENU_SOUND),
    ID_QUIT(6, "Quit", SoundPath.MENU_SOUND),
    ID_PAUSE(7, "Pause", SoundPath.MENU_SOUND),
    ID_BACK(8, "Back", SoundPath.MENU_SOUND);

    private final int id;
    private final String name;
    private final SoundPath sound;

    private IdGUI(final int id, final String name, final SoundPath sound){
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

    public SoundPath getSound() {
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
