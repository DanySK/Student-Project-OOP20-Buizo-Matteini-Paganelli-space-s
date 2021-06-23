package spacesurvival.view.menu.factorymethod;

import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.view.utilities.GraphicsLayoutUtils;
import spacesurvival.view.menu.FactoryGuiMenu;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.menu.concrete.GUIMenuConcrete;
import spacesurvival.view.menu.utilities.IconsButton;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

/**
 * Implements the creation of the compact menu GUI.
 */
public class GUIMenuCompact implements FactoryGuiMenu {

    /**
     * {@inheritDoc}
     */
    @Override
    public GUIMenu createGui() {
        final GUIMenuConcrete menuConcrete = new GUIMenuConcrete();

        menuConcrete.setFontGUI(GraphicsLayoutUtils.FONT_STANDARD_H5);
        menuConcrete.setForegroundGUI(GraphicsLayoutUtils.COLOR_4);
        menuConcrete.setFontTitleGUI(GraphicsLayoutUtils.getFontForTitle(GraphicsLayoutUtils.SIZE_FONT_H2));
        menuConcrete.setColumnsNamePlayer(DesignJComponent.SIZE_COLUMNS_TEXT);
        this.createGraphics(menuConcrete);
        return menuConcrete;
    }

    /**
     * Create graphics compact menu GUI.
     * 
     * @param menu to create the graphics.
     */
    private void createGraphics(final GUIMenuConcrete menu) {
        menu.setLayout(new GridBagLayout());
        int nBtnUsed = 0;

        final GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(DesignJComponent.SIZE_SPACE_TITLE);
        menu.add(menu.getLabelTitle(), lim);

        FactoryGUIs.resetGridBagConstraints(lim);
        lim.gridy++;

        menu.getBtnActionLinks().forEach(FactoryGUIs::setTransparentJButton);

        menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getTxfNamePlayer(),
                menu.getBtnActionLinks().get(nBtnUsed++))), lim);

        while (nBtnUsed < EngineMenu.N_BUTTONS) {
            lim.gridy++;
            menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getBtnActionLinks().get(nBtnUsed++),
                    nBtnUsed + FactoryGUIs.STEP_INDEX < EngineMenu.N_BUTTONS 
                    ? menu.getBtnActionLinks().get(nBtnUsed++) : FactoryGUIs.getJComponentEmpty())), lim);
        }

        nBtnUsed = 0;
        while (nBtnUsed < EngineMenu.N_BUTTONS) {
            FactoryGUIs.setIconJButtonFromRate(menu.getButton(nBtnUsed),
                    IconsButton.values()[nBtnUsed++].getPath(), ScaleOf.ICON_FULL, menu.getWidth());
        }
    }
}
