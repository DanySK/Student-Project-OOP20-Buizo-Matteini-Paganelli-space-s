package game;

import controller.GUI.*;
import controller.sound.CallerAudio;
import factorys.StaticFactoryEngineGUI;
import factorys.StaticFactoryGUI;
import model.sound.category.SoundLoop;
import utilities.SoundPath;
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

    private SoundPath soundPath = CtrlGUI.FIRST_GUI.getSound();
    private final CallerAudio remoteControllerAudio = new CallerAudio(new SoundLoop(soundPath));

    private final CtrlSound ctrlSound = new CtrlSound(StaticFactoryGUI.createSoundGUI(),
            StaticFactoryEngineGUI.createEngineSound());

    private final CtrlGUI ctrlGUI = new CtrlGUI(List.of(ctrlMenu, ctrlGame, ctrlSettings,
            ctrlScoreboard, ctrlSound, ctrlHelp));

    public SpaceMala(){

    }
}
