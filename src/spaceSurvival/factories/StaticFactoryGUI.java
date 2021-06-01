package spaceSurvival.factories;

import spaceSurvival.view.dead.FactoryGUIDead;
import spaceSurvival.view.dead.GUIDead;
import spaceSurvival.view.dead.factoryMethod.GUIDeadStandard;
import spaceSurvival.view.loading.FactoryGUILoading;
import spaceSurvival.view.loading.GUILoading;
import spaceSurvival.view.loading.factoryMethod.GUILoadingStandard;
import spaceSurvival.view.game.FactoryGUIGame;
import spaceSurvival.view.game.GUIGame;
import spaceSurvival.view.game.factoryMethod.GUIGameStandard;
import spaceSurvival.view.help.factoryMethod.GUIHelpStandard;
import spaceSurvival.view.help.FactoryGUIHelp;
import spaceSurvival.view.help.GUIHelp;
import spaceSurvival.view.menu.factoryMethod.GUIMenuStandard;
import spaceSurvival.view.menu.FactoryGUIMenu;
import spaceSurvival.view.menu.GUIMenu;
import spaceSurvival.view.pause.FactoryGUIPause;
import spaceSurvival.view.pause.GUIPause;
import spaceSurvival.view.pause.factoryMethod.GUIPauseStandard;
import spaceSurvival.view.scoreboard.factoryMethod.GUIScoreboardStandard;
import spaceSurvival.view.scoreboard.FactoryGUIScoreboard;
import spaceSurvival.view.scoreboard.GUIScoreboard;
import spaceSurvival.view.settings.factoryMethod.GUISettingsStandard;
import spaceSurvival.view.settings.FactoryGUISettings;
import spaceSurvival.view.settings.GUISettings;
import spaceSurvival.view.sound.FactoryGUISound;
import spaceSurvival.view.sound.GUISound;
import spaceSurvival.view.sound.factoryMethod.GUISoundStandard;

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
