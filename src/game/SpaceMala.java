package game;

import controller.GUI.*;
import factorys.StaticFactoryEngineGUI;
import factorys.StaticFactoryGUI;
import view.GUI.game.GUIGame;

import java.util.List;

public class SpaceMala {



    private final CtrlMenu ctrlMenu = new CtrlMenu(StaticFactoryGUI.createMenuGUI(),
            StaticFactoryEngineGUI.createEngineMenu());

    private final CtrlGame ctrlGame = new CtrlGame( StaticFactoryEngineGUI.createEngineGame(),
            StaticFactoryGUI.createGameGUI());

    private final CtrlScoreboard ctrlScoreboard = new CtrlScoreboard(StaticFactoryGUI.createScoreboardGUI(),
            StaticFactoryEngineGUI.createEngineScoreboard());

    private final CtrlSettings ctrlSettings = new CtrlSettings(StaticFactoryGUI.createSettingsGUI(),
            StaticFactoryEngineGUI.createEngineSettings());

    private final CtrlHelp ctrlHelp = new CtrlHelp(StaticFactoryGUI.createHelpGUI(),
            StaticFactoryEngineGUI.createEngineHelp());

    private final CtrlSound ctrlSound = new CtrlSound(StaticFactoryGUI.createSoundGUI(),
            StaticFactoryEngineGUI.createEngineSound());

    private GUIGame game = StaticFactoryGUI.createGameGUI();

    private final CtrlGUI CtrlGUI = new CtrlGUI(List.of(ctrlMenu, ctrlGame, ctrlSettings, ctrlScoreboard, ctrlSound, ctrlHelp));

    public SpaceMala(){
    }
}
