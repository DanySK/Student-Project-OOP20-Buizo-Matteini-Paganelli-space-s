package view.factoryGUI;

import view.factoryGUI.factoryHelpGUI.factoryMethod.HelpGUIStandard;
import view.factoryGUI.factoryHelpGUI.interfaceHelp.FactoryHelpGUI;
import view.factoryGUI.factoryHelpGUI.interfaceHelp.HelpGUI;
import view.factoryGUI.factoryMenuGUI.factoryMethod.MenuGUICompact;
import view.factoryGUI.factoryMenuGUI.factoryMethod.MenuGUIStandard;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.FactoryMenuGUI;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.MenuGUI;
import view.factoryGUI.factoryScoreboardGUI.factoryMethod.ScoreboardGUIReverse;
import view.factoryGUI.factoryScoreboardGUI.factoryMethod.ScoreboardGUIStandard;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.FactoryScoreboardGUI;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.ScoreboardGUI;
import view.factoryGUI.factorySettingsGUI.factoryMethod.SettingsGUIStandard;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.FactorySettingsGUI;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.SettingsGUI;

public class FactoryGUI {

    public static MenuGUI createMenuGUI(){
        FactoryMenuGUI menuGUI = new MenuGUIStandard();
        return menuGUI.createGUI();
    }

    public static ScoreboardGUI createScoreboardGUI(){
        FactoryScoreboardGUI scoreboardGUI = new ScoreboardGUIStandard();
        return scoreboardGUI.createGUI();
    }

    public static SettingsGUI createSettingsGUI() {
        FactorySettingsGUI settingsGUI = new SettingsGUIStandard();
        return settingsGUI.create();
    }

    public static HelpGUI creteHelpGUI(){
        FactoryHelpGUI helpGUI = new HelpGUIStandard();
        return helpGUI.create();
    }


}
