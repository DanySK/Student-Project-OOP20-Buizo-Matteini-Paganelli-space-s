package game;

import controller.GUI.*;
import model.GUI.help.EngineHelp;
import model.GUI.menu.EngineMenu;
import model.GUI.scoreboard.EngineScoreboard;
import model.GUI.settings.EngineSettings;
import view.GUI.StaticFactoryGUI;
import view.GUI.help.GUIHelp;
import view.GUI.menu.GUIMenu;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.settings.GUISettings;

import java.util.List;

public class SpaceMala {

    private GUIMenu GUIMenu = StaticFactoryGUI.createMenuGUI();
    private EngineMenu menuEngine = new EngineMenu();
    private CtrlMenu ctrlMenu = new CtrlMenu(GUIMenu, menuEngine);

    private GUIScoreboard scoreboardGUI = StaticFactoryGUI.createScoreboardGUI();
    private EngineScoreboard scoreboardEngine = new EngineScoreboard();
    private CtrlScoreboard ctrlScoreboard = new CtrlScoreboard(scoreboardGUI, scoreboardEngine);

    private GUISettings GUISettings = StaticFactoryGUI.createSettingsGUI();
    private EngineSettings settingsEngine = new EngineSettings();
    private CtrlSettings ctrlSettings = new CtrlSettings(GUISettings, settingsEngine);

    private GUIHelp GUIHelp = StaticFactoryGUI.creteHelpGUI();
    private EngineHelp engineHelp = new EngineHelp();
    private CtrlHelp ctrlHelp = new CtrlHelp(GUIHelp, engineHelp);

    private CtrlGUI CtrlGUI = new CtrlGUI(List.of(GUIMenu, scoreboardGUI, GUISettings, GUIHelp),
            List.of(menuEngine, scoreboardEngine, settingsEngine, engineHelp));

    public SpaceMala(){

    }
}
