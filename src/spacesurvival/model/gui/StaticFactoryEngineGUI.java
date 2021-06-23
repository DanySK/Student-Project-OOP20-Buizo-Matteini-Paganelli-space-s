package spacesurvival.model.gui;

import spacesurvival.model.gui.dead.EngineDead;
import spacesurvival.model.gui.game.EngineGame;
import spacesurvival.model.gui.help.EngineHelp;
import spacesurvival.model.gui.loading.EngineLoading;
import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.model.gui.pause.EnginePause;
import spacesurvival.model.gui.scoreboard.EngineScoreboard;
import spacesurvival.model.gui.settings.EngineSettings;
import spacesurvival.model.gui.sound.EngineSound;

/**
 * StaticFactoryEngineGUI create gui models
 *
 */
public class StaticFactoryEngineGUI {

    /**
     * Create a model of the loading gui.
     *
     * @return loading gui model
     */
    public static EngineLoading createLoading() {
        return new EngineLoading();
    }

    /**
     * Create a model of the game gui.
     *
     * @return game gui model
     */
    public static EngineGame createEngineGame() {
        return new EngineGame();
    }

    /**
     * Create a model of the menu gui.
     *
     * @return menu gui model
     */
    public static EngineMenu createEngineMenu() {
        return new EngineMenu();
    }

    /**
     * Create a model of the settings gui.
     *
     * @return settings gui model
     */
    public static EngineSettings createEngineSettings() {
        return new EngineSettings();
    }

    /**
     * Create a model of the scoreboard gui.
     *
     * @return scoreboard gui model
     */
    public static EngineScoreboard createEngineScoreboard() {
        return new EngineScoreboard();
    }

    /**
     * Create a model of the sound gui.
     *
     * @return sound gui model
     */
    public static EngineSound createEngineSound() {
        return new EngineSound();
    }

    /**
     * Create a model of the help gui.
     *
     * @return help gui model
     */
    public static EngineHelp createEngineHelp() {
        return new EngineHelp();
    }

    /**
     * Create a model of the pause gui.
     *
     * @return pause gui model
     */
    public static EnginePause createEnginePause() {
        return new EnginePause();
    }

    /**
     * Create a model of the dead gui.
     *
     * @return dead gui model
     */
    public static EngineDead createEngineDead() {
        return new EngineDead();
    }
}
