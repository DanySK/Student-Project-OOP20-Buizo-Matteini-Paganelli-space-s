package factories;

import view.dead.FactoryGUIDead;
import view.dead.GUIDead;
import view.dead.factoryMethod.GUIDeadStandard;
import view.loading.FactoryGUILoading;
import view.loading.GUILoading;
import view.loading.factoryMethod.GUILoadingStandard;
import view.game.FactoryGUIGame;
import view.game.GUIGame;
import view.game.factoryMethod.GUIGameStandard;
import view.help.factoryMethod.GUIHelpStandard;
import view.help.FactoryGUIHelp;
import view.help.GUIHelp;
import view.menu.factoryMethod.GUIMenuStandard;
import view.menu.FactoryGUIMenu;
import view.menu.GUIMenu;
import view.pause.FactoryGUIPause;
import view.pause.GUIPause;
import view.pause.factoryMethod.GUIPauseStandard;
import view.scoreboard.factoryMethod.GUIScoreboardStandard;
import view.scoreboard.FactoryGUIScoreboard;
import view.scoreboard.GUIScoreboard;
import view.settings.factoryMethod.GUISettingsStandard;
import view.settings.FactoryGUISettings;
import view.settings.GUISettings;
import view.sound.FactoryGUISound;
import view.sound.GUISound;
import view.sound.factoryMethod.GUISoundStandard;

public class StaticFactoryGUI {

    public static GUILoading createLoading(){
        FactoryGUILoading factoryGUILoading = new GUILoadingStandard();
        return factoryGUILoading.create();
    }

    public static GUIMenu createMenuGUI(){
        FactoryGUIMenu menuGUI = new GUIMenuStandard();
        return menuGUI.createGUI();
    }

    public static GUIScoreboard createScoreboardGUI(){
        FactoryGUIScoreboard scoreboardGUI = new GUIScoreboardStandard();
        return scoreboardGUI.createGUI();
    }

    public static GUISettings createSettingsGUI() {
        FactoryGUISettings settingsGUI = new GUISettingsStandard();
        return settingsGUI.create();
    }

    public static GUIHelp createHelpGUI(){
        FactoryGUIHelp helpGUI = new GUIHelpStandard();
        return helpGUI.create();
    }

    public static GUISound createSoundGUI(){
        FactoryGUISound soundGUI = new GUISoundStandard();
        return soundGUI.create();
    }

    public static GUIGame createGameGUI(){
        FactoryGUIGame gameGUI = new GUIGameStandard();
        return gameGUI.create();
    }

    public static GUIPause createPauseGUI(){
        FactoryGUIPause pauseGUI = new GUIPauseStandard();
        return pauseGUI.create();
    }

    public static GUIDead createDeadGUI(){
        FactoryGUIDead deadGUI = new GUIDeadStandard();
        return deadGUI.create();
    }

}
