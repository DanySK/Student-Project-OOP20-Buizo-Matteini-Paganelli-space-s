package spacesurvival.controller.gui;

import spacesurvival.controller.gui.focusgui.FocusGUI;
import spacesurvival.controller.gui.logicswitch.LogicSwitchGUI;
import spacesurvival.controller.gui.logicswitch.ManagerVibility;
import spacesurvival.controller.utilities.ListGUI;
import spacesurvival.model.gui.StaticFactoryEngineGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.dead.factorymethod.GUIDeadStandard;
import spacesurvival.view.game.factorymethod.GUIGameStandard;
import spacesurvival.view.help.factorymethod.GUIHelpStandard;
import spacesurvival.view.menu.factorymethod.GUIMenuStandard;
import spacesurvival.view.pause.factorymethod.GUIPauseStandard;
import spacesurvival.view.settings.factorymethod.GUISettingsStandard;
import spacesurvival.view.sound.factorymethod.GUISoundStandard;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.StateLevelGUI;
import spacesurvival.utilities.path.Background;
import spacesurvival.view.utilities.ButtonLink;

import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ManagerControllerGUI {
    /**
     * 
     */
    public static final LinkActionGUI FIRST_GUI = LinkActionGUI.LINK_MENU;

    private final ControllerMenu ctrlMenu;
    private final ControllerGame ctrlGame;
    private final ControllerSettings ctrlSettings;
    private final ControllerSound ctrlSound;
    private final ControllerHelp ctrlHelp;
    private final ControllerPause ctrlPause;
    private final ControllerDead ctrlDead;

    private final ListGUI<LinkActionGUI> chronology;
    private final Map<LinkActionGUI, ControllerGUI> managerGui;

    private final LogicSwitchGUI managerVisibility;
    private final MouseListener fosucGUI;

    public ManagerControllerGUI() {
        this.ctrlMenu = new ControllerMenu(StaticFactoryEngineGUI.createEngineMenu(), new GUIMenuStandard().create());
        this.ctrlGame = new ControllerGame(StaticFactoryEngineGUI.createEngineGame(), new GUIGameStandard().create());
        this.ctrlSettings = new ControllerSettings(StaticFactoryEngineGUI.createEngineSettings(), new GUISettingsStandard().create());
        this.ctrlSound = new ControllerSound(StaticFactoryEngineGUI.createEngineSound(), new GUISoundStandard().create());
        this.ctrlHelp = new ControllerHelp(StaticFactoryEngineGUI.createEngineHelp(), new GUIHelpStandard().create());
        this.ctrlPause = new ControllerPause(StaticFactoryEngineGUI.createEnginePause(), new GUIPauseStandard().create());
        this.ctrlDead = new ControllerDead(StaticFactoryEngineGUI.createEngineDead(), new GUIDeadStandard().create());

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
        this.managerVisibility = new ManagerVibility(this.chronology, this.managerGui);
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
            value.assignBounds();
        });
    }

    public boolean isInGameOver(){
        return this.chronology.contains(LinkActionGUI.LINK_DEAD);
    }

    public boolean isInGame(){
        return this.chronology.contains(LinkActionGUI.LINK_GAME);
    }

    public boolean isInPause(){
        return this.chronology.contains(LinkActionGUI.LINK_PAUSE);
    }

    public void startGUI(){
        this.managerGui.get(FIRST_GUI).turn(Visibility.VISIBLE);
    }

    private void linksAll() {
        this.managerGui.values().forEach(managerGui -> managerGui.getGUI().getBtnActionLinks().forEach(btn ->
                btn.addActionListener(e -> {
                    if (this.isInPause()) {
                        this.managerVisibility.algorithmSwitchGame(btn.getCurrentLink(), btn.getNextLink());
                       this.ctrlGame.setPauseAnimationAllObject(true);
                    } else {
                        this.managerVisibility.algorithmSwitchNormal(btn.getCurrentLink(), btn.getNextLink());
                    }

                    if (this.isInGame()) {
                        this.ctrlGame.setPauseAnimationAllObject(false);
                    }
        })));
    }

    private void focusGUI() {
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

    public Optional<LinkActionGUI> getCurrentGUI(){
        return this.chronology.lastElementOfList();
    }

    public ControllerGame getCtrlGame() {
        return this.ctrlGame;
    }

    public ControllerSound getCtrlSound() {
        return this.ctrlSound;
    }

    public void endGame(){
        
        this.chronology.lastElementOfList().ifPresent(link -> this.managerGui.get(link).turn(Visibility.HIDDEN));
        this.chronology.lastElementOfList().ifPresent( this.chronology::remove);
        
        this.chronology.add(LinkActionGUI.LINK_DEAD);
        this.managerGui.get(LinkActionGUI.LINK_DEAD).turn(Visibility.VISIBLE);

        this.ctrlGame.stopTimer();
    }

    private void startElementsWhenInGame() {

        this.getLinkBtnFromGUI(LinkActionGUI.LINK_MENU, LinkActionGUI.LINK_GAME).ifPresent(link -> {
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
        this.getLinkBtnFromGUI(LinkActionGUI.LINK_DEAD, LinkActionGUI.LINK_MENU).ifPresent(link -> {
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
                    if(btn.getCurrentLink() == LinkActionGUI.LINK_PAUSE && btn.getNextLink() == LinkActionGUI.LINK_BACK) {
                        this.ctrlSound.checkChangeSoundLoop(LinkActionGUI.LINK_GAME);
                    } else {
                        this.ctrlSound.checkChangeSoundLoop(btn.getNextLink());
                    }
                })
        ));
    }
}
