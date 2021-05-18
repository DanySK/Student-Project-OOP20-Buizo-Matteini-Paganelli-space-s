package controller.GUI;

import controller.sound.CallerAudio;
import controller.utilities.ListGUI;
import factorys.StaticFactoryEngineGUI;
import factorys.StaticFactoryGUI;
import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.GUI.game.EngineGame;
import model.GUI.help.EngineHelp;
import model.GUI.menu.EngineMenu;
import model.GUI.pause.EnginePause;
import model.GUI.scoreboard.EngineScoreboard;
import model.GUI.settings.EngineSettings;
import model.GUI.sound.EngineSound;
import model.image.EngineImage;
import utilities.IdGUI;
import utilities.SoundPath;
import utilities.StateLevelGUI;
import view.GUI.GUI;
import view.GUI.game.GUIGame;
import view.GUI.help.GUIHelp;
import view.GUI.menu.GUIMenu;
import view.GUI.pause.GUIPause;
import view.GUI.scoreboard.GUIScoreboard;
import view.GUI.settings.GUISettings;
import view.GUI.sound.GUISound;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CtrlGUI {
    public static final IdGUI FIRST_GUI = IdGUI.ID_MENU;

    private final GUIMenu guiMenu;
    private final GUIGame guiGame;
    private final GUISettings guiSettings;
    private final GUIScoreboard guiScoreboard;
    private final GUISound guiSound;
    private final GUIHelp guiHelp;
    private final GUIPause guiPause;

    private final EngineMenu engineMenu;
    private final EngineGame engineGame;
    private final EngineSettings engineSettings;
    private final EngineScoreboard engineScoreboard;
    private final EngineSound engineSound;
    private final EngineHelp engineHelp;
    private final EnginePause enginePause;

    private final CtrlMenu ctrlMenu;
    private final CtrlGame ctrlGame;
    private final CtrlSettings ctrlSettings;
    private final CtrlScoreboard ctrlScoreboard;
    private final CtrlSound ctrlSound;
    private final CtrlHelp ctrlHelp;
    private final CtrlPause ctrlPause;

    private final Map<IdGUI, ControllerGUI> managerGui;

    private final ListGUI<IdGUI> chronology;

    public CtrlGUI(){
        this.engineMenu = StaticFactoryEngineGUI.createEngineMenu();
        this.engineGame = StaticFactoryEngineGUI.createEngineGame();
        this.engineSettings = StaticFactoryEngineGUI.createEngineSettings();
        this.engineScoreboard = StaticFactoryEngineGUI.createEngineScoreboard();
        this.engineSound = StaticFactoryEngineGUI.createEngineSound();
        this.engineHelp = StaticFactoryEngineGUI.createEngineHelp();
        this.enginePause = StaticFactoryEngineGUI.creEnginePause();

        this.guiMenu = StaticFactoryGUI.createMenuGUI();
        this.guiGame = StaticFactoryGUI.createGameGUI();
        this.guiSettings = StaticFactoryGUI.createSettingsGUI();
        this.guiScoreboard = StaticFactoryGUI.createScoreboardGUI();
        this.guiSound = StaticFactoryGUI.createSoundGUI();
        this.guiHelp = StaticFactoryGUI.createHelpGUI();
        this.guiPause = StaticFactoryGUI.createPauseGUI();

        this.ctrlMenu = new CtrlMenu(this.engineMenu, this.guiMenu);
        this.ctrlGame = new CtrlGame(this.engineGame, this.guiGame);
        this.ctrlSettings = new CtrlSettings(this.engineSettings, this.guiSettings);
        this.ctrlScoreboard = new CtrlScoreboard(this.engineScoreboard, this.guiScoreboard);
        this.ctrlSound = new CtrlSound(this.engineSound, this.guiSound);
        this.ctrlHelp = new CtrlHelp(this.engineHelp, this.guiHelp);
        this.ctrlPause = new CtrlPause(this.enginePause, this.guiPause);

        this.managerGui = new HashMap<>(){{
            put(CtrlGUI.this.ctrlMenu.getId(), CtrlGUI.this.ctrlMenu);
            put(CtrlGUI.this.ctrlGame.getId(), CtrlGUI.this.ctrlGame);
            put(CtrlGUI.this.ctrlSettings.getId(), CtrlGUI.this.ctrlSettings);
            put(CtrlGUI.this.ctrlScoreboard.getId(), CtrlGUI.this.ctrlScoreboard);
            put(CtrlGUI.this.ctrlSound.getId(), CtrlGUI.this.ctrlSound);
            put(CtrlGUI.this.ctrlHelp.getId(), CtrlGUI.this.ctrlHelp);
            put(CtrlGUI.this.ctrlPause.getId(), CtrlGUI.this.ctrlPause);
        }};

        this.chronology = new ListGUI<>() {{ add(FIRST_GUI); }};

        this.linksAll();
        this.focusMenu();

        this.managerGui.get(FIRST_GUI).turn(Visibility.VISIBLE);
    }

    private void linksAll(){
        this.managerGui.values().forEach(managerGui -> managerGui.getGUI().getButtonLinks().forEach(btn -> {
            btn.addActionListener(e -> {
                System.out.println("Premuto in: " + btn.getIdGUICurrent() + " Vado in: " + btn.getIdGUINext());

                switch (btn.getIdGUINext()) {
                    case ID_GAME:
                        this.chronology.add(btn.getIdGUINext());
                        this.managerGui.get(btn.getIdGUINext()).turn(Visibility.VISIBLE);
                        this.managerGui.get(btn.getIdGUICurrent()).turn(Visibility.HIDDEN); break;

                    case ID_PAUSE:
                        if (this.chronology.lastElementOfList() != IdGUI.ID_PAUSE) {
                            this.chronology.add(btn.getIdGUINext());
                        } else {
                            this.chronology.remove(btn.getIdGUINext());
                        }

                        this.managerGui.get(btn.getIdGUINext()).changeVisibility(); break;

                    case ID_BACK:
                        this.managerGui.get(btn.getIdGUICurrent()).turn(Visibility.HIDDEN);
                        this.chronology.remove(this.chronology.lastElementOfList()); break;

                    case ID_QUIT: this.quitAll(); break;
                    default:
                        this.chronology.add(btn.getIdGUINext());
                        this.managerGui.get(btn.getIdGUINext()).turn(Visibility.VISIBLE); break;
                }
                System.out.println("list" + this.chronology);

            });
        }));
    }

    private void focusMenu(){
        this.managerGui.values().forEach(managerGui ->
                managerGui.getGUI().addMouseListener(this.getMouseListener(managerGui.getId())));
    }

    private MouseListener getMouseListener(final IdGUI id){
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) {
                if(id.getStateLevel().equals(StateLevelGUI.FOREGROUND) &&
                        chronology.lastElementOfList().getStateLevel().equals(StateLevelGUI.OVERLAY)){

                    int sizeList = chronology.size() - 1;
                    while(chronology.get(sizeList).getStateLevel().equals(StateLevelGUI.OVERLAY) ){
                        CtrlGUI.this.managerGui.get(chronology.get(sizeList)).turn(Visibility.HIDDEN);
                        chronology.remove(sizeList--);
                    }
                    System.out.println("list" + chronology);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        };
    }

    public GUIGame getPanelGame(){
        return this.guiGame;
    }

    private EngineGUI getEngine(IdGUI id){
        for (ControllerGUI ctrlGUI : this.managerGui.values()) {
            if(ctrlGUI.getId() == id){
                return ctrlGUI.getEngine();
            }
        }
        return null;
    }

    private GUI getGUI(IdGUI id){
        for (ControllerGUI ctrlGUI : this.managerGui.values()) {
            if(ctrlGUI.getId() == id){
                return ctrlGUI.getGUI();
            }
        }
        return null;
    }

    public IdGUI getCurrentGUI(){
        return this.chronology.lastElementOfList();
    }

    public SoundPath getCurrentSound(){
        return this.chronology.lastElementOfList().getSound();
    }

    public void linksCallerAudioLoopWith(final CallerAudio callerAudioLoop){
        this.ctrlSound.setCallerAudioLoop(callerAudioLoop);
        this.ctrlSound.getCallerAudioLoop().setSound(callerAudioLoop.getSound());
        this.ctrlSound.linksCallerAudioLoopWithListener();
    }

    public void linksCallerAudioEffectWith(final List<CallerAudio> callerAudioEffects){
        this.ctrlSound.setCallerAudioEffect(callerAudioEffects);
        AtomicInteger index = new AtomicInteger(0);
        
        callerAudioEffects.forEach(callerAudioEffect -> {   
        	this.ctrlSound.getCallerAudioEffect().get(index.get()).setSound(callerAudioEffect.getSound());
        	index.incrementAndGet();     	
        });
        this.ctrlSound.linksCallerAudioEffectWithListener();
    }

    public int getCurrentLoopVolume(){
        return this.ctrlSound.getBackgroundVolume();
    }

    public boolean isActiveLoopUnitSound(){
        return this.ctrlSound.isActiveLoopUnitSound();
    }


    public String getCurrentSkin(){
        return this.ctrlSettings.getCurrentSkin();
    }

    public void initTimer(){
        this.ctrlGame.initTimer();
    }

    public void startTimer(){
        this.ctrlGame.startTimer();
    }

    public void renderTimer(){
        this.ctrlGame.assignTimer();
    }

    public boolean isStartTimer(){
        return this.ctrlGame.isStartTimer();
    }

    private void quitAll(){
        this.managerGui.values().forEach(managerGui -> managerGui.getGUI().close());
    }
}
