package spacesurvival.controller.gui;

import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.dead.EngineDead;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.dead.GUIDead;

public class CtrlDead implements ControllerGUI {
    private final EngineDead engine;
    private final GUIDead gui;

    private final SwitchGUI switchGUI;

    public CtrlDead(final EngineDead engine, final GUIDead gui) {
        this.engine = engine;
        this.gui = gui;

        this.switchGUI = new SwitchGUI(engine, gui);
        this.switchGUI.turn(this.engine.getVisibility());
    }


    @Override
    public void assignLinks() {
        this.gui.setMainAction(this.engine.getMainLink());
        this.gui.setBtnActions(this.engine.getMainLink(), this.engine.getLinks());
    }

    @Override
    public void assignTexts() {
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListNameLinks());
    }

    @Override
    public void assignRectangle() {
        this.gui.setBounds(this.engine.getRectangle());
    }

    @Override
    public LinkActionGUI getMainLink() {
        return this.engine.getMainLink();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }

    @Override
    public void closeGUI() {
        this.gui.close();
    }
}
