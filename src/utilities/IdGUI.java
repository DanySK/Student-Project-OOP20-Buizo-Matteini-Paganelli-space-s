package utilities;

public enum IdGUI {
    ID_MENU(0, "Menu", SoundPath.MENU_SOUND, StateLevelGUI.FOREGROUND),
    ID_GAME(1, "Game", SoundPath.GAME_SOUND, StateLevelGUI.FOREGROUND),
    ID_SETTING(2, "Settings", SoundPath.MENU_SOUND, StateLevelGUI.OVERLAY),
    ID_SCOREBOARD(3, "Scoreboard", SoundPath.MENU_SOUND, StateLevelGUI.OVERLAY),
    ID_SOUND(4, "Sound", SoundPath.MENU_SOUND, StateLevelGUI.OVERLAY),
    ID_HELP(5, "Help", SoundPath.MENU_SOUND, StateLevelGUI.OVERLAY),
    ID_QUIT(6, "Quit", SoundPath.MENU_SOUND, StateLevelGUI.NOTHING),
    ID_PAUSE(7, "Pause", SoundPath.MENU_SOUND, StateLevelGUI.OVERLAY),
    ID_BACK(8, "Back", SoundPath.MENU_SOUND, StateLevelGUI.NOTHING);

    private final int id;
    private final String name;
    private final SoundPath sound;
    private final StateLevelGUI level;

    private IdGUI(final int id, final String name, final SoundPath sound, final StateLevelGUI level){
        this.id = id;
        this.name = name;
        this.sound = sound;
        this.level = level;
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

    public StateLevelGUI getStateLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return "IdGUI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
