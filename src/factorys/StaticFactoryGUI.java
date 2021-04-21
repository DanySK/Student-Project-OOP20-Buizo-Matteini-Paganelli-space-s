package factorys;

import view.GUI.game.FactoryGUIGame;
import view.GUI.game.GUIGame;
import view.GUI.game.factoryMethod.GUIGameStandard;
import view.GUI.help.factoryMethod.GUIHelpStandard;
import view.GUI.help.FactoryGUIHelp;
import view.GUI.help.GUIHelp;
import view.GUI.menu.factoryMethod.GUIMenuCompact;
import view.GUI.menu.factoryMethod.GUIMenuStandard;
import view.GUI.menu.FactoryGUIMenu;
import view.GUI.menu.GUIMenu;
import view.GUI.scoreboard.factoryMethod.GUIScoreboardStandard;
import view.GUI.scoreboard.FactoryGUIScoreboard;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.settings.factoryMethod.GUISettingsStandard;
import view.GUI.settings.FactoryGUISettings;
import view.GUI.settings.GUISettings;
import view.GUI.sound.FactoryGUISound;
import view.GUI.sound.GUISound;
import view.GUI.sound.factoryMethod.GUISoundStandard;

public class StaticFactoryGUI {

    public static GUIMenu createMenuGUI(){
        FactoryGUIMenu menuGUI = new GUIMenuCompact();
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

}
