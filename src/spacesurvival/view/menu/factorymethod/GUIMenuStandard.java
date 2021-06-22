package spacesurvival.view.menu.factorymethod;

import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.utilities.path.Background;
import spacesurvival.view.utilities.GraphicsUtils;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.view.menu.FactoryGuiMenu;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.menu.concrete.GUIMenuConcrete;
import spacesurvival.view.menu.utilities.IconsButton;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

/**
 * Implements the creation of the standard menu GUI.
 *
 */
public class GUIMenuStandard implements FactoryGuiMenu {

    /**
     * {@inheritDoc}
     */
    @Override
    public GUIMenu createGui() {
        final GUIMenuConcrete menuConcrete = new GUIMenuConcrete();
        menuConcrete.setFontGUI(GraphicsUtils.FONT_STANDARD_H5);
        menuConcrete.setForegroundGUI(GraphicsUtils.COLOR_4);
        menuConcrete.setFontTitleGUI(GraphicsUtils.getFontForTitle(GraphicsUtils.SIZE_FONT_H2));
        menuConcrete.setColumnsNamePlayer(DesignJComponent.SIZE_COLUMNS_TEXT);
        menuConcrete.setImageBackground(Background.MAIN);

        this.createGraphics(menuConcrete);
        return menuConcrete;
    }

    /**
     * Create graphics standard menu GUI.
     */
    private void createGraphics(final GUIMenuConcrete menu) {
        menu.setLayout(new GridBagLayout());
        int nBtnUsed = 0;

        final GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(DesignJComponent.SIZE_SPACE_TITLE);
        menu.add(menu.getLbTitle(), lim);

        FactoryGUIs.resetGridBagConstraints(lim);
        lim.gridy++;

        menu.getBtnActionLinks().forEach(FactoryGUIs::setTransparentJButton);

        menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getTxfNamePlayer(),
                menu.getBtnActionLinks().get(nBtnUsed++))), lim);

        while (nBtnUsed < EngineMenu.N_BUTTONS) {
            lim.gridy++;
            menu.add(menu.getButton(nBtnUsed++), lim);
        }

        nBtnUsed = 0;
        while (nBtnUsed < EngineMenu.N_BUTTONS) {
            FactoryGUIs.setIconJButtonFromRate(menu.getButton(nBtnUsed),
                    IconsButton.values()[nBtnUsed++].getPath(), ScaleOf.ICON_FULL, menu.getWidth());
        }
    }

}
