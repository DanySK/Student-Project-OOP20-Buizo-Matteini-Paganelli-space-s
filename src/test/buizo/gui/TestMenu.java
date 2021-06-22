package test.buizo.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import spacesurvival.controller.gui.CtrlMenu;
import spacesurvival.model.gui.StaticFactoryEngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.view.StaticFactoryGUI;
import spacesurvival.view.menu.GUIMenu;

public class TestMenu {

    @Test
    public void testLinkMenu() {
        final EngineMenu engine = StaticFactoryEngineGUI.createEngineMenu();
        final GUIMenu gui = StaticFactoryGUI.createMenuGUI();
        final CtrlMenu controller = new CtrlMenu(engine, gui);

        controller.assignLinks();
        assertEquals(controller.getMainLink(), engine.getMainLink());

        controller.assignTexts();
        for (int i = 0; i < EngineMenu.N_BUTTONS; i++) {
            assertEquals(gui.getBtnActionLinks().get(i).getNextLink(), engine.getLinks().get(i));
            assertEquals(controller.getMainLink(), gui.getBtnActionLinks().get(i).getCurrentLink());
        }
    }

    @Test
    public void testTextMenu() {
        final EngineMenu engine = StaticFactoryEngineGUI.createEngineMenu();
        final GUIMenu gui = StaticFactoryGUI.createMenuGUI();
        final CtrlMenu controller = new CtrlMenu(engine, gui);

        controller.assignTexts();
        for (int i = 0; i < EngineMenu.N_BUTTONS; i++) {
            assertEquals(gui.getBtnActionLinks().get(i).getText(), engine.getListNameLinks().get(i));
        }
    }

    @Test
    public void testVisibilityMenu() {
        final EngineMenu engine = StaticFactoryEngineGUI.createEngineMenu();
        final GUIMenu gui = StaticFactoryGUI.createMenuGUI();
        final CtrlMenu controller = new CtrlMenu(engine, gui);

        controller.turn(Visibility.VISIBLE);

        assertTrue(engine.isVisible());
    }
}
