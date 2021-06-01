package spaceSurvival.factories;

import spaceSurvival.model.GUI.dead.EngineDead;
import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.model.GUI.help.EngineHelp;
import spaceSurvival.model.GUI.loading.EngineLoading;
import spaceSurvival.model.GUI.menu.EngineMenu;
import spaceSurvival.model.GUI.pause.EnginePause;
import spaceSurvival.model.GUI.scoreboard.EngineScoreboard;
import spaceSurvival.model.GUI.settings.EngineSettings;
import spaceSurvival.model.GUI.sound.EngineSound;

public class StaticFactoryEngineGUI {

    public static EngineLoading createLoading(){
        return new EngineLoading();
    }

    public static EngineGame createEngineGame(){
        return new EngineGame();
    }

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

    public static EnginePause createEnginePause(){
        return new EnginePause();
    }

    public static EngineDead createEngineDead(){
        return new EngineDead();
    }
}
