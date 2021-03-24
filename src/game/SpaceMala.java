package game;

import controller.GUI.*;
import model.factoryGUI.helpGUI.HelpEngine;
import model.factoryGUI.menuGUI.MenuEngine;
import model.factoryGUI.scoreboardGUI.ScoreboardEngine;
import model.factoryGUI.settingsGUI.SettingsEngine;
import view.factoryGUI.FactoryGUI;
import view.factoryGUI.factoryHelpGUI.interfaceHelp.HelpGUI;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.MenuGUI;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.ScoreboardGUI;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.SettingsGUI;

import java.util.List;

public class SpaceMala {

    private MenuGUI menuGUI = FactoryGUI.createMenuGUI();
    private MenuEngine menuEngine = new MenuEngine();
    private ControllerMenu controllerMenu = new ControllerMenu(menuGUI, menuEngine);

    private ScoreboardGUI scoreboardGUI = FactoryGUI.createScoreboardGUI();
    private ScoreboardEngine scoreboardEngine = new ScoreboardEngine();
    private ControllerScoreboard controllerScoreboard = new ControllerScoreboard(scoreboardGUI, scoreboardEngine);

    private SettingsGUI settingsGUI = FactoryGUI.createSettingsGUI();
    private SettingsEngine settingsEngine = new SettingsEngine();
    private ControllerSettings controllerSettings = new ControllerSettings(settingsGUI, settingsEngine);

    private HelpGUI helpGUI = FactoryGUI.creteHelpGUI();
    private HelpEngine helpEngine = new HelpEngine();
    private ControllerHelp help = new ControllerHelp(helpGUI, helpEngine);

    private ControllerGUI controllerGUI = new ControllerGUI(List.of(menuGUI, scoreboardGUI, settingsGUI, helpGUI),
            List.of(menuEngine, scoreboardEngine, settingsEngine, helpEngine));

    public SpaceMala(){

    }

//    public ControllerMenu getControllerMenu() {
//        return this.controllerMenu;
//    }
//
//    public ControllerScoreboard getControllerScoreboard(){
//        return this.controllerScoreboard;
//    }

}
