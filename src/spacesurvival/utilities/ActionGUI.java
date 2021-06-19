package spacesurvival.utilities;

import spacesurvival.utilities.path.Background;
import spacesurvival.utilities.path.SoundPath;


public enum ActionGUI {
    ID_MENU(0, "Menu", SoundPath.MENU, Background.MAIN, StateLevelGUI.FOREGROUND),
    ID_GAME(1, "Game", SoundPath.GAME, Background.GAME, StateLevelGUI.FOREGROUND),
    ID_SETTING(2, "Settings", SoundPath.MENU, Background.MAIN, StateLevelGUI.OVERLAY),
    ID_SCOREBOARD(3, "Scoreboard", SoundPath.MENU, Background.MAIN, StateLevelGUI.OVERLAY),
    ID_SOUND(4, "Sound", SoundPath.MENU, Background.MAIN, StateLevelGUI.OVERLAY),
    ID_HELP(5, "Help", SoundPath.MENU, Background.MAIN, StateLevelGUI.OVERLAY),
    ID_QUIT(6, "Quit", SoundPath.MENU, Background.MAIN, StateLevelGUI.NOTHING),
    ID_PAUSE(7, "Pause", SoundPath.MENU, Background.MAIN, StateLevelGUI.OVERLAY),
    ID_LOADING(8, "Loading", SoundPath.MENU, Background.MAIN, StateLevelGUI.FOREGROUND),
    ID_BACK(9, "Back", SoundPath.MENU, Background.MAIN, StateLevelGUI.NOTHING),
    ID_DEAD(10, "Dead", SoundPath.MENU, Background.DEAD2, StateLevelGUI.FOREGROUND);

    private final int id;
    private final String name;
    private final SoundPath sound;
    private final String background;
    private final StateLevelGUI level;

    private ActionGUI(final int id, final String name, final SoundPath sound, final String background, final StateLevelGUI level){
        this.id = id;
        this.name = name;
        this.sound = sound;
        this.level = level;
        this.background = background;
    }

    public int getIdInt() {
        return this.id;
    }

    public String getIdName() {
        return this.name;
    }

    public SoundPath getSound() {
        return this.sound;
    }

    public String getBackground() {
        return this.background;
    }

    public StateLevelGUI getStateLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return "IdGUI{"
                + "id=" 
                + id 
                + ", name='" + name + '\'' 
                + '}';
    }
}
