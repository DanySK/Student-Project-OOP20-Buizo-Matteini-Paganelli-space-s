package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.strategy.LogicSwitchGUI;
import spaceSurvival.controller.GUI.strategy.LogicSwitchGame;
import spaceSurvival.controller.GUI.strategy.LogicSwitchMenu;
import spaceSurvival.controller.utilities.ListGUI;
import spaceSurvival.factories.StaticFactoryEngineGUI;
import spaceSurvival.factories.StaticFactoryGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.StateLevelGUI;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.view.utilities.BtnAction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CtrlGUI {
    public static final ActionGUI FIRST_GUI = ActionGUI.ID_MENU;

    private final CtrlMenu ctrlMenu;
    private final CtrlGame ctrlGame;
    private final CtrlSettings ctrlSettings;
    private final CtrlScoreboard ctrlScoreboard;
    private final CtrlSound ctrlSound;
    private final CtrlHelp ctrlHelp;
    private final CtrlPause ctrlPause;
    private final CtrlDead ctrlDead;

    private final Map<ActionGUI, ControllerGUI> managerGui;

    private final ListGUI<ActionGUI> chronology;

    private final LogicSwitchGUI logicSwitchMenu;
    private final LogicSwitchGUI logicSwitchGame;

    public CtrlGUI(){
        this.ctrlMenu = new CtrlMenu(StaticFactoryEngineGUI.createEngineMenu(), StaticFactoryGUI.createMenuGUI());
        this.ctrlGame = new CtrlGame(StaticFactoryEngineGUI.createEngineGame(), StaticFactoryGUI.createGameGUI());
        this.ctrlSettings = new CtrlSettings(StaticFactoryEngineGUI.createEngineSettings(), StaticFactoryGUI.createSettingsGUI());
        this.ctrlScoreboard = new CtrlScoreboard(StaticFactoryEngineGUI.createEngineScoreboard(), StaticFactoryGUI.createScoreboardGUI());
        this.ctrlSound = new CtrlSound(StaticFactoryEngineGUI.createEngineSound(), StaticFactoryGUI.createSoundGUI());
        this.ctrlHelp = new CtrlHelp(StaticFactoryEngineGUI.createEngineHelp(), StaticFactoryGUI.createHelpGUI());
        this.ctrlPause = new CtrlPause(StaticFactoryEngineGUI.createEnginePause(), StaticFactoryGUI.createPauseGUI());
        this.ctrlDead = new CtrlDead(StaticFactoryEngineGUI.createEngineDead(), StaticFactoryGUI.createDeadGUI());

        this.managerGui = new HashMap<>(){{
            put(CtrlGUI.this.ctrlMenu.getMainAction(), CtrlGUI.this.ctrlMenu);
            put(CtrlGUI.this.ctrlGame.getMainAction(), CtrlGUI.this.ctrlGame);
            put(CtrlGUI.this.ctrlSettings.getMainAction(), CtrlGUI.this.ctrlSettings);
            put(CtrlGUI.this.ctrlScoreboard.getMainAction(), CtrlGUI.this.ctrlScoreboard);
            put(CtrlGUI.this.ctrlSound.getMainAction(), CtrlGUI.this.ctrlSound);
            put(CtrlGUI.this.ctrlHelp.getMainAction(), CtrlGUI.this.ctrlHelp);
            put(CtrlGUI.this.ctrlPause.getMainAction(), CtrlGUI.this.ctrlPause);
            put(CtrlGUI.this.ctrlDead.getMainAction(), CtrlGUI.this.ctrlDead);
        }};

        this.chronology = new ListGUI<>() {{ add(FIRST_GUI); }};

        this.logicSwitchMenu = new LogicSwitchMenu();
        this.logicSwitchGame = new LogicSwitchGame();

        this.linksAll();
        this.focusMenu();
        this.startElementWhenInGame();
        this.restartGame();
    }

    public boolean isInGameOver(){
        return this.chronology.contains(ActionGUI.ID_DEAD);
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
        this.managerGui.values().forEach(managerGui -> managerGui.getGUI().getBtnActionLinks().forEach(btn ->
                btn.addActionListener(e -> {
                    System.out.println("Premuto in: " + btn.getActionCurrent() + " Vado in: " + btn.getActionNext());
                    if(this.isInPause()){
                        this.logicSwitchGame.algorithm(btn.getActionCurrent(), btn.getActionNext(),
                        this.chronology, this.managerGui);
                    } else {
                        this.logicSwitchMenu.algorithm(btn.getActionCurrent(), btn.getActionNext(),
                        this.chronology, this.managerGui);
                    }
                    System.out.println("list" + this.chronology);
        })));
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

    public void EndGame(){
        this.managerGui.get(this.chronology.lastElementOfList()).turn(Visibility.HIDDEN);
        this.chronology.remove(this.chronology.lastElementOfList());
        this.chronology.add(ActionGUI.ID_DEAD);
        this.managerGui.get(ActionGUI.ID_DEAD).turn(Visibility.VISIBLE);
        System.out.println("list" + chronology);
    }

    private void startElementWhenInGame() {
        Objects.requireNonNull(this.getBtnGameFromMenu()).addActionListener(l -> {
            this.ctrlGame.getWorld().setSkin(CtrlGUI.this.getCurrentSkin());
            this.ctrlGame.startTimer();
            this.ctrlGame.startPaint();
            this.managerGui.values().forEach(control -> {
                if(control.getMainAction().getStateLevel().equals(StateLevelGUI.OVERLAY)){
                    control.getGUI().setImageBackground(Background.TRANSPARENT);
                }

            });
        });
    }

    private void restartGame(){
        Objects.requireNonNull(this.getBtnMenuFromDead()).addActionListener(l -> {
            this.chronology.remove(this.chronology.lastElementOfList());
            this.managerGui.values().forEach(control ->
                    control.getGUI().setImageBackground(control.getMainAction().getBackground()));
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

    private BtnAction getBtnMenuFromDead(){
        for (BtnAction btn : this.ctrlDead.getGUI().getBtnActionLinks()) {
            if(btn.getActionNext() == ActionGUI.ID_MENU){
                return btn;
            }
        }
        return null;
    }

    public void assignSoundLoop() {
        this.managerGui.values().forEach(ctrl -> ctrl.getGUI().getBtnActionLinks().forEach(
                btn -> btn.addActionListener(l -> {

                    System.out.println("Bottone dopo ---------- " + btn.getActionNext());

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
