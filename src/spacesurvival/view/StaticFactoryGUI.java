package spacesurvival.view;

import spacesurvival.view.dead.FactoryGUIDead;
import spacesurvival.view.dead.GUIDead;
import spacesurvival.view.dead.factorymethod.GUIDeadStandard;
import spacesurvival.view.loading.FactoryGUILoading;
import spacesurvival.view.loading.GUILoading;
import spacesurvival.view.loading.factorymethod.GUILoadingStandard;
import spacesurvival.view.game.FactoryGUIGame;
import spacesurvival.view.game.GUIGame;
import spacesurvival.view.game.factorymethod.GUIGameStandard;
import spacesurvival.view.help.factorymethod.GUIHelpStandard;
import spacesurvival.view.help.FactoryGUIHelp;
import spacesurvival.view.help.GUIHelp;
import spacesurvival.view.menu.factorymethod.GUIMenuStandard;
import spacesurvival.view.menu.FactoryGuiMenu;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.pause.FactoryGUIPause;
import spacesurvival.view.pause.GUIPause;
import spacesurvival.view.pause.factorymethod.GUIPauseStandard;
import spacesurvival.view.scoreboard.factorymethod.GUIScoreboardStandard;
import spacesurvival.view.scoreboard.FactoryGUIScoreboard;
import spacesurvival.view.scoreboard.GUIScoreboard;
import spacesurvival.view.settings.factorymethod.GUISettingsStandard;
import spacesurvival.view.settings.FactoryGUISettings;
import spacesurvival.view.settings.GUISettings;
import spacesurvival.view.sound.FactoryGUISound;
import spacesurvival.view.sound.GUISound;
import spacesurvival.view.sound.factorymethod.GUISoundStandard;

/**
 * StaticFactoryGUI create GUIs from their individual factories.
 */
public final class StaticFactoryGUI {
    private StaticFactoryGUI() {
    }

    /**
     * Create a loading GUI from the factory.
     *
     * @return loading GUI.
     */
    public static GUILoading createLoading() {
        final FactoryGUILoading factoryGUILoading = new GUILoadingStandard();
        return factoryGUILoading.create();
    }

    /**
     * Create a menu GUI from the factory.
     * @return menu GUI.
     */
    public static GUIMenu createMenuGUI() {
        final FactoryGuiMenu menuGUI = new GUIMenuStandard();
        return menuGUI.createGui();
    }

    /**
     * Create a scoreboard GUI from the factory.
     * @return scoreboard GUI.
     */
    public static GUIScoreboard createScoreboardGUI() {
        final FactoryGUIScoreboard scoreboardGUI = new GUIScoreboardStandard();
        return scoreboardGUI.createGUI();
    }

    /**
     * Create a settings GUI from the factory.
     * @return settings GUI.
     */
    public static GUISettings createSettingsGUI() {
        final FactoryGUISettings settingsGUI = new GUISettingsStandard();
        return settingsGUI.create();
    }

    /**
     * Create a help GUI from the factory.
     * @return help GUI.
     */
    public static GUIHelp createHelpGUI() {
        final FactoryGUIHelp helpGUI = new GUIHelpStandard();
        return helpGUI.create();
    }

    /**
     * Create a sound GUI from the factory.
     * @return sound GUI.
     */
    public static GUISound createSoundGUI() {
        final FactoryGUISound soundGUI = new GUISoundStandard();
        return soundGUI.create();
    }

    /**
     * Create a game GUI from the factory.
     * @return game GUI.
     */
    public static GUIGame createGameGUI() {
        final FactoryGUIGame gameGUI = new GUIGameStandard();
        return gameGUI.create();
    }

    /**
     * Create a pause GUI from the factory.
     * @return pause GUI.
     */
    public static GUIPause createPauseGUI() {
        final FactoryGUIPause pauseGUI = new GUIPauseStandard();
        return pauseGUI.create();
    }

    /**
     * Create a dead GUI from the factory.
     * @return dead GUI.
     */
    public static GUIDead createDeadGUI() {
        final FactoryGUIDead deadGUI = new GUIDeadStandard();
        return deadGUI.create();
    }
}
