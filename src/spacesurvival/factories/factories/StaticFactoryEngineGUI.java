package spacesurvival.factories.factories;

import spacesurvival.model.gui.dead.EngineDead;
import spacesurvival.model.gui.game.EngineGame;
import spacesurvival.model.gui.help.EngineHelp;
import spacesurvival.model.gui.loading.EngineLoading;
import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.model.gui.pause.EnginePause;
import spacesurvival.model.gui.scoreboard.EngineScoreboard;
import spacesurvival.model.gui.settings.EngineSettings;
import spacesurvival.model.gui.sound.EngineSound;

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
