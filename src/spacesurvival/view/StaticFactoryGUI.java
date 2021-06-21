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
import spacesurvival.view.menu.FactoryGUIMenu;
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
 * StaticFactoryGUI create GUIs from their individual factories
 *
 */
public class StaticFactoryGUI {

    /**
     * Create a loading gui from the factory
     *
     * @return loading gui
     */
    public static GUILoading createLoading(){
        FactoryGUILoading factoryGUILoading = new GUILoadingStandard();
        return factoryGUILoading.create();
    }

    /**
     * Create a menu gui from the factory
     *
     * @return menu gui
     */
    public static GUIMenu createMenuGUI(){
        FactoryGUIMenu menuGUI = new GUIMenuStandard();
        return menuGUI.createGUI();
    }

    /**
     * Create a scoreboard gui from the factory
     *
     * @return scoreboard gui
     */
    public static GUIScoreboard createScoreboardGUI(){
        FactoryGUIScoreboard scoreboardGUI = new GUIScoreboardStandard();
        return scoreboardGUI.createGUI();
    }

    /**
     * Create a settings gui from the factory
     *
     * @return settings gui
     */
    public static GUISettings createSettingsGUI() {
        FactoryGUISettings settingsGUI = new GUISettingsStandard();
        return settingsGUI.create();
    }

    /**
     * Create a help gui from the factory
     *
     * @return help gui
     */
    public static GUIHelp createHelpGUI(){
        FactoryGUIHelp helpGUI = new GUIHelpStandard();
        return helpGUI.create();
    }

    /**
     * Create a sound gui from the factory
     *
     * @return sound gui
     */
    public static GUISound createSoundGUI(){
        FactoryGUISound soundGUI = new GUISoundStandard();
        return soundGUI.create();
    }

    /**
     * Create a game gui from the factory
     *
     * @return game gui
     */
    public static GUIGame createGameGUI(){
        FactoryGUIGame gameGUI = new GUIGameStandard();
        return gameGUI.create();
    }

    /**
     * Create a pause gui from the factory
     *
     * @return pause gui
     */
    public static GUIPause createPauseGUI(){
        FactoryGUIPause pauseGUI = new GUIPauseStandard();
        return pauseGUI.create();
    }

    /**
     * Create a dead gui from the factory
     *
     * @return dead gui
     */
    public static GUIDead createDeadGUI(){
        FactoryGUIDead deadGUI = new GUIDeadStandard();
        return deadGUI.create();
    }

}
