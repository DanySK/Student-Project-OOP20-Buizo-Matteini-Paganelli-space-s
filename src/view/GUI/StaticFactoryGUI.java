package view.GUI;

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

public class StaticFactoryGUI {

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

    public static GUIHelp creteHelpGUI(){
        FactoryGUIHelp helpGUI = new GUIHelpStandard();
        return helpGUI.create();
    }


}
