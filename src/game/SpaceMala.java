package game;

import controller.GUI.*;
import model.factoryGUI.helpGUI.HelpEngine;
import model.factoryGUI.menuGUI.MenuEngine;
import model.factoryGUI.scoreboardGUI.ScoreboardEngine;
import model.factoryGUI.settingsGUI.SettingsEngine;
import view.factoryGUI.FactoryGUI;
import view.factoryGUI.factoryHelpGUI.HelpGUI;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.MenuGUI;
import view.factoryGUI.factoryScoreboardGUI.interfaceScoreboard.ScoreboardGUI;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.SettingsGUI;

import java.util.List;

public class SpaceMala {

    private MenuGUI menuGUI = FactoryGUI.createMenuGUI();
    private MenuEngine menuEngine = new MenuEngine();
    private Menu menu = new Menu(menuGUI, menuEngine);

    private ScoreboardGUI scoreboardGUI = FactoryGUI.createScoreboardGUI();
    private ScoreboardEngine scoreboardEngine = new ScoreboardEngine();
    private Scoreboard scoreboard = new Scoreboard(scoreboardGUI, scoreboardEngine);

    private SettingsGUI settingsGUI = FactoryGUI.createSettingsGUI();
    private SettingsEngine settingsEngine = new SettingsEngine();
    private Settings settings = new Settings(settingsGUI, settingsEngine);

    private HelpGUI helpGUI = FactoryGUI.creteHelpGUI();
    private HelpEngine helpEngine = new HelpEngine();
    private Help help = new Help(helpGUI, helpEngine);

    private GUI GUI = new GUI(List.of(menuGUI, scoreboardGUI, settingsGUI, helpGUI),
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
