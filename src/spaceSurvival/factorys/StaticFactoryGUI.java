package spaceSurvival.factorys;

import spaceSurvival.view.GUI.loading.FactoryGUILoading;
import spaceSurvival.view.GUI.loading.GUILoading;
import spaceSurvival.view.GUI.loading.factoryMethod.GUILoadingStandard;
import spaceSurvival.view.GUI.game.FactoryGUIGame;
import spaceSurvival.view.GUI.game.GUIGame;
import spaceSurvival.view.GUI.game.factoryMethod.GUIGameStandard;
import spaceSurvival.view.GUI.help.factoryMethod.GUIHelpStandard;
import spaceSurvival.view.GUI.help.FactoryGUIHelp;
import spaceSurvival.view.GUI.help.GUIHelp;
import spaceSurvival.view.GUI.menu.factoryMethod.GUIMenuStandard;
import spaceSurvival.view.GUI.menu.FactoryGUIMenu;
import spaceSurvival.view.GUI.menu.GUIMenu;
import spaceSurvival.view.GUI.pause.FactoryGUIPause;
import spaceSurvival.view.GUI.pause.GUIPause;
import spaceSurvival.view.GUI.pause.factoryMethod.GUIPauseStandard;
import spaceSurvival.view.GUI.scoreboard.factoryMethod.GUIScoreboardStandard;
import spaceSurvival.view.GUI.scoreboard.FactoryGUIScoreboard;
import spaceSurvival.view.GUI.scoreboard.GUIScoreboard;
import spaceSurvival.view.GUI.settings.factoryMethod.GUISettingsStandard;
import spaceSurvival.view.GUI.settings.FactoryGUISettings;
import spaceSurvival.view.GUI.settings.GUISettings;
import spaceSurvival.view.GUI.sound.FactoryGUISound;
import spaceSurvival.view.GUI.sound.GUISound;
import spaceSurvival.view.GUI.sound.factoryMethod.GUISoundStandard;

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
}
