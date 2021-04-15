package game;

import controller.GUI.*;
import model.GUI.StaticFactoryEngineGUI;
import view.GUI.StaticFactoryGUI;

import java.util.List;

public class SpaceMala {

    private final CtrlMenu ctrlMenu = new CtrlMenu(StaticFactoryGUI.createMenuGUI(),
            StaticFactoryEngineGUI.createEngineMenu());

    private final CtrlScoreboard ctrlScoreboard = new CtrlScoreboard(StaticFactoryGUI.createScoreboardGUI(),
            StaticFactoryEngineGUI.createEngineScoreboard());

    private final CtrlSettings ctrlSettings = new CtrlSettings(StaticFactoryGUI.createSettingsGUI(),
            StaticFactoryEngineGUI.createEngineSettings());

    private final CtrlHelp ctrlHelp = new CtrlHelp(StaticFactoryGUI.createHelpGUI(),
            StaticFactoryEngineGUI.createEngineHelp());

    private final CtrlSound ctrlSound = new CtrlSound(StaticFactoryGUI.createSoundGUI(),
            StaticFactoryEngineGUI.createEngineSound());

    private final CtrlGUI CtrlGUI = new CtrlGUI(List.of(ctrlMenu, ctrlSettings, ctrlScoreboard, ctrlSound, ctrlHelp));

    public SpaceMala(){
    }
}
