package spacesurvival.factories;

import spacesurvival.model.GUI.dead.EngineDead;
import spacesurvival.model.GUI.game.EngineGame;
import spacesurvival.model.GUI.help.EngineHelp;
import spacesurvival.model.GUI.loading.EngineLoading;
import spacesurvival.model.GUI.menu.EngineMenu;
import spacesurvival.model.GUI.pause.EnginePause;
import spacesurvival.model.GUI.scoreboard.EngineScoreboard;
import spacesurvival.model.GUI.settings.EngineSettings;
import spacesurvival.model.GUI.sound.EngineSound;

public class StaticFactoryEngineGUI {

    public static EngineLoading createLoading() {
        return new EngineLoading();
    }

    public static EngineGame createEngineGame() {
        return new EngineGame();
    }

    public static EngineMenu createEngineMenu() {
        return new EngineMenu();
    }

    public static EngineSettings createEngineSettings() {
        return new EngineSettings();
    }

    public static EngineScoreboard createEngineScoreboard() {
        return new EngineScoreboard();
    }

    public static EngineSound createEngineSound() {
        return new EngineSound();
    }

    public static EngineHelp createEngineHelp() {
        return new EngineHelp();
    }

    public static EnginePause createEnginePause() {
        return new EnginePause();
    }

    public static EngineDead createEngineDead() {
        return new EngineDead();
    }
}
