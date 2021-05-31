package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.strategy.LogicSwitchGUI;
import spaceSurvival.controller.GUI.strategy.LogicSwitchGame;
import spaceSurvival.controller.GUI.strategy.LogicSwitchMenu;
import spaceSurvival.controller.utilities.ListGUI;
import spaceSurvival.factories.StaticFactoryEngineGUI;
import spaceSurvival.factories.StaticFactoryGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.model.GUI.help.EngineHelp;
import spaceSurvival.model.GUI.menu.EngineMenu;
import spaceSurvival.model.GUI.pause.EnginePause;
import spaceSurvival.model.GUI.scoreboard.EngineScoreboard;
import spaceSurvival.model.GUI.settings.EngineSettings;
import spaceSurvival.model.GUI.sound.EngineSound;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.StateLevelGUI;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.game.GUIGame;
import spaceSurvival.view.help.GUIHelp;
import spaceSurvival.view.menu.GUIMenu;
import spaceSurvival.view.pause.GUIPause;
import spaceSurvival.view.scoreboard.GUIScoreboard;
import spaceSurvival.view.settings.GUISettings;
import spaceSurvival.view.sound.GUISound;
import spaceSurvival.view.utilities.BtnAction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CtrlGUI {
    public static final ActionGUI FIRST_GUI = ActionGUI.ID_MENU;

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

    private final Map<ActionGUI, ControllerGUI> managerGui;

    private final ListGUI<ActionGUI> chronology;

    private final LogicSwitchGUI logicSwitchMenu;
    private final LogicSwitchGUI logicSwitchGame;

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
            put(CtrlGUI.this.ctrlMenu.getMainAction(), CtrlGUI.this.ctrlMenu);
            put(CtrlGUI.this.ctrlGame.getMainAction(), CtrlGUI.this.ctrlGame);
            put(CtrlGUI.this.ctrlSettings.getMainAction(), CtrlGUI.this.ctrlSettings);
            put(CtrlGUI.this.ctrlScoreboard.getMainAction(), CtrlGUI.this.ctrlScoreboard);
            put(CtrlGUI.this.ctrlSound.getMainAction(), CtrlGUI.this.ctrlSound);
            put(CtrlGUI.this.ctrlHelp.getMainAction(), CtrlGUI.this.ctrlHelp);
            put(CtrlGUI.this.ctrlPause.getMainAction(), CtrlGUI.this.ctrlPause);
        }};

        this.chronology = new ListGUI<>() {{ add(FIRST_GUI); }};

        this.logicSwitchMenu = new LogicSwitchMenu();
        this.logicSwitchGame = new LogicSwitchGame();

        this.linksAll();
        this.focusMenu();
        this.assignStartTimer();
    }

    public boolean isInGame(){
        return this.chronology.contains(ActionGUI.ID_GAME);
    }

    public boolean isInPause(){
        return this.chronology.contains(ActionGUI.ID_PAUSE);
    }

    public boolean isStateIn(final ActionGUI actionGUI){
        return this.chronology.contains(actionGUI);
    }

    public void startGUI(){
        this.managerGui.get(FIRST_GUI).turn(Visibility.VISIBLE);
    }

    private void linksAll(){
        this.managerGui.values().forEach(managerGui -> managerGui.getGUI().getBtnActionLinks().forEach(btn -> {
            btn.addActionListener(e -> {
                System.out.println("Premuto in: " + btn.getActionCurrent() + " Vado in: " + btn.getActionNext());

                if(this.isInPause()){
                    this.logicSwitchGame.algorithm(btn.getActionCurrent(), btn.getActionNext(),
                            this.chronology, this.managerGui);
                } else{
                    this.logicSwitchMenu.algorithm(btn.getActionCurrent(), btn.getActionNext(),
                            this.chronology, this.managerGui);
                }
                System.out.println("list" + this.chronology);

            });
        }));
    }

    private void focusMenu(){
        this.managerGui.values().forEach(managerGui ->
                managerGui.getGUI().addMouseListener(this.getMouseListener(managerGui.getMainAction())));
    }

    private MouseListener getMouseListener(final ActionGUI id){
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
                    CtrlGUI.this.ctrlSound.checkChangeSoundLoop(CtrlGUI.this.getCurrentGUI());
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

    public ActionGUI getCurrentGUI(){
        return this.chronology.lastElementOfList();
    }

    public String getCurrentSkin(){
        return this.ctrlSettings.getCurrentSkin();
    }

    public CtrlGame getCtrlGame() {
        return this.ctrlGame;
    }

    public CtrlSound getCtrlSound() {
        return this.ctrlSound;
    }

    private void assignStartTimer() {
        Objects.requireNonNull(this.getBtnGameFromMenu()).addActionListener(l -> {
            this.ctrlGame.getWord().setSkin(CtrlGUI.this.getCurrentSkin());
            this.ctrlGame.startTimer();
            this.ctrlGame.startPaint();
            this.managerGui.values().forEach(control -> {
                if(control.getMainAction() != ActionGUI.ID_GAME){
                    control.getGUI().setImageBackground(Background.TRANSPARENT);
                }

            });
        });
    }

    private BtnAction getBtnGameFromMenu(){
        for (BtnAction btn : this.ctrlMenu.getGUI().getBtnActionLinks()) {
            if(btn.getActionNext() == ActionGUI.ID_GAME){
                return btn;
            }
        }
        return null;
    }

    public void assignSoundLoop(){
        this.managerGui.values().forEach(ctrl -> ctrl.getGUI().getBtnActionLinks().forEach(
                btn -> btn.addActionListener(l -> {
                    if(btn.getActionCurrent() == ActionGUI.ID_PAUSE && btn.getActionNext() == ActionGUI.ID_BACK) {
                        CtrlGUI.this.ctrlSound.checkChangeSoundLoop(ActionGUI.ID_GAME);
                    } else {
                        CtrlGUI.this.ctrlSound.checkChangeSoundLoop(btn.getActionNext());
                    }
                })
        ));
    }



    public void initTimer(){
        this.ctrlGame.initTimer();
    }

}
