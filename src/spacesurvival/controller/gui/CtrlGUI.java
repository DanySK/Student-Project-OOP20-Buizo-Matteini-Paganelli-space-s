package spacesurvival.controller.gui;

import spacesurvival.controller.gui.commandfocus.FocusGUI;
import spacesurvival.controller.gui.strategy.LogicSwitchGUI;
import spacesurvival.controller.gui.strategy.LogicSwitchGame;
import spacesurvival.controller.gui.strategy.LogicSwitchMenu;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.StaticFactoryEngineGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.StaticFactoryGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.StateLevelGUI;
import spacesurvival.utilities.path.Background;
import spacesurvival.view.utilities.ButtonLink;

import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CtrlGUI {

    public static final LinkActionGUI FIRST_GUI = LinkActionGUI.ID_MENU;

    private final CtrlMenu ctrlMenu;
    private final CtrlGame ctrlGame;
    private final CtrlSettings ctrlSettings;
    private final CtrlSound ctrlSound;
    private final CtrlHelp ctrlHelp;
    private final CtrlPause ctrlPause;
    private final CtrlDead ctrlDead;

    private final ListGUI<LinkActionGUI> chronology;

    private final Map<LinkActionGUI, ControllerGUI> managerGui;

    private final MouseListener fosucGUI;
    private final LogicSwitchGUI logicSwitchMenu;
    private final LogicSwitchGUI logicSwitchGame;


    public CtrlGUI() {
        this.ctrlMenu = new CtrlMenu(StaticFactoryEngineGUI.createEngineMenu(), StaticFactoryGUI.createMenuGUI());
        this.ctrlGame = new CtrlGame(StaticFactoryEngineGUI.createEngineGame(), StaticFactoryGUI.createGameGUI());
        this.ctrlSettings = new CtrlSettings(StaticFactoryEngineGUI.createEngineSettings(), StaticFactoryGUI.createSettingsGUI());
        this.ctrlSound = new CtrlSound(StaticFactoryEngineGUI.createEngineSound(), StaticFactoryGUI.createSoundGUI());
        this.ctrlHelp = new CtrlHelp(StaticFactoryEngineGUI.createEngineHelp(), StaticFactoryGUI.createHelpGUI());
        this.ctrlPause = new CtrlPause(StaticFactoryEngineGUI.createEnginePause(), StaticFactoryGUI.createPauseGUI());
        this.ctrlDead = new CtrlDead(StaticFactoryEngineGUI.createEngineDead(), StaticFactoryGUI.createDeadGUI());

        this.managerGui = new HashMap<>();
        this.managerGui.put(this.ctrlMenu.getMainLink(), this.ctrlMenu);
        this.managerGui.put(this.ctrlGame.getMainLink(), this.ctrlGame);
        this.managerGui.put(this.ctrlSettings.getMainLink(), this.ctrlSettings);
        this.managerGui.put(this.ctrlSound.getMainLink(), this.ctrlSound);
        this.managerGui.put(this.ctrlHelp.getMainLink(), this.ctrlHelp);
        this.managerGui.put(this.ctrlPause.getMainLink(), this.ctrlPause);
        this.managerGui.put(this.ctrlDead.getMainLink(), this.ctrlDead);

        this.chronology = new ListGUI<>();

        this.fosucGUI = new FocusGUI(this);
        this.logicSwitchMenu = new LogicSwitchMenu();
        this.logicSwitchGame = new LogicSwitchGame();
    }

    public Map<LinkActionGUI, ControllerGUI> getManagerGui() {
        return this.managerGui;
    }

    public ListGUI<LinkActionGUI> getChronology() {
        return this.chronology;
    }

    public void initGUI() {
        this.chronology.add(FIRST_GUI);
        this.focusGUI();
        this.assignAllLinkAction();
        this.assignAllString();
        this.assignAllRectangle();
        this.linksAll();

        this.startElementsWhenInGame();
        this.restartGame();
    }

    public void assignAllLinkAction() {
        this.managerGui.forEach((key, value) -> {
            value.assignLinks();
        });
    }

    public void assignAllString() {
        this.managerGui.forEach((key, value) -> {
            value.assignTexts();
        });
    }

    public void assignAllRectangle() {
        this.managerGui.forEach((key, value) -> {
            value.assignRectangle();
        });
    }

    public boolean isInGameOver(){
        return this.chronology.contains(LinkActionGUI.ID_DEAD);
    }

    public boolean isInGame(){
        return this.chronology.contains(LinkActionGUI.ID_GAME);
    }

    public boolean isInPause(){
        return this.chronology.contains(LinkActionGUI.ID_PAUSE);
    }

    public void startGUI(){
        this.managerGui.get(FIRST_GUI).turn(Visibility.VISIBLE);
    }

    private void linksAll(){
        this.managerGui.values().forEach(managerGui -> managerGui.getGUI().getBtnActionLinks().forEach(btn ->
                btn.addActionListener(e -> {
                    if (this.isInPause()){
                        this.logicSwitchGame.algorithm(btn.getCurrentLink(), btn.getNextLink(),
                                this.chronology, this.managerGui);
                       this.ctrlGame.setPauseAnimationAllObject(true);
                    } else {
                        this.logicSwitchMenu.algorithm(btn.getCurrentLink(), btn.getNextLink(),
                                this.chronology, this.managerGui);
                    }

                    if (this.isInGame()) {
                        this.ctrlGame.setPauseAnimationAllObject(false);
                    }
        })));
    }

    private void focusGUI(){
        this.managerGui.values().forEach(managerGui ->
                managerGui.getGUI().addMouseListener(this.fosucGUI));
    }

    public Optional<ControllerGUI> getControllerGUIFromGUI(final GUI gui){
        for (final ControllerGUI ctrl : this.managerGui.values()) {
            if(ctrl.getGUI() == gui) {
                return Optional.of(ctrl);
            }
        }
        return Optional.empty();
    }

    public LinkActionGUI getCurrentGUI(){
        return this.chronology.lastElementOfList();
    }

    public CtrlGame getCtrlGame() {
        return this.ctrlGame;
    }

    public CtrlSound getCtrlSound() {
        return this.ctrlSound;
    }

    public void endGame(){
        this.managerGui.get(this.chronology.lastElementOfList()).turn(Visibility.HIDDEN);
        this.chronology.remove(this.chronology.lastElementOfList());
        this.chronology.add(LinkActionGUI.ID_DEAD);
        this.managerGui.get(LinkActionGUI.ID_DEAD).turn(Visibility.VISIBLE);

        this.ctrlGame.stopTimer();
    }

    private void startElementsWhenInGame() {

        this.getLinkBtnFromGUI(LinkActionGUI.ID_MENU, LinkActionGUI.ID_GAME).ifPresent(link -> {
            link.addActionListener(e -> {
                this.ctrlGame.setSkin(this.ctrlSettings.getCurrentSkin());
                this.ctrlGame.getWorld().getTakeableFactoryThread().start();
                this.managerGui.values().forEach(control -> {
                    if (control.getMainLink().getStateLevel().equals(StateLevelGUI.OVERLAY)) {
                        control.getGUI().setImageBackground(Background.TRANSPARENT);
                    }
                });
            });
        });

    }

    private void restartGame() {
        this.getLinkBtnFromGUI(LinkActionGUI.ID_DEAD, LinkActionGUI.ID_MENU).ifPresent(link -> {
            link.addActionListener(e -> {
                this.ctrlGame.restartGame();
                this.managerGui.values().forEach(control ->
                        control.getGUI().setImageBackground(control.getMainLink().getBackground()));
            });
        });
    }

    private Optional<ButtonLink> getLinkBtnFromGUI(final LinkActionGUI gui, final LinkActionGUI btn){
        for (final ControllerGUI ctrl : this.managerGui.values()) {
            if (ctrl.getMainLink().equals(gui)) {
                for (final ButtonLink link :  ctrl.getGUI().getBtnActionLinks()) {
                    if (link.getNextLink() == btn) {
                        return Optional.of(link);
                    }
                }
            }
        }
        return Optional.empty();
    }

    public void assignSoundLoop() {
        this.managerGui.values().forEach(ctrl -> ctrl.getGUI().getBtnActionLinks().forEach(
                btn -> btn.addActionListener(l -> {
                    this.ctrlSound.checkChangeSoundLoop(btn.getCurrentLink() == LinkActionGUI.ID_PAUSE 
                            && btn.getNextLink() == LinkActionGUI.ID_BACK 
                            ? LinkActionGUI.ID_GAME : btn.getNextLink());
                })
        ));
    }
}
