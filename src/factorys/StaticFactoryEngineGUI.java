package factorys;

import model.GUI.help.EngineHelp;
import model.GUI.menu.EngineMenu;
import model.GUI.scoreboard.EngineScoreboard;
import model.GUI.settings.EngineSettings;
import model.GUI.sound.EngineSound;

public class StaticFactoryEngineGUI {

    public static EngineMenu createEngineMenu(){
        return new EngineMenu();
    }

    public static EngineSettings createEngineSettings(){
        return new EngineSettings();
    }

    public static EngineScoreboard createEngineScoreboard(){
        return new EngineScoreboard();
    }

    public static EngineSound createEngineSound(){
        return new EngineSound();
    }

    public static EngineHelp createEngineHelp(){
        return new EngineHelp();
    }
}
