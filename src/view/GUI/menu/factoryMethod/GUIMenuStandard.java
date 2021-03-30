package view.GUI.menu.factoryMethod;

import utilities.DesignSpace;
import view.GUI.menu.FactoryGUIMenu;
import view.GUI.menu.GUIMenu;
import view.GUI.menu.concrete.GUIMenuConcrete;
import view.utilities.FactoryGUIs;

import java.awt.*;

import java.util.List;

public class GUIMenuStandard implements FactoryGUIMenu {
    private final view.GUI.menu.concrete.GUIMenuConcrete GUIMenuConcrete = new GUIMenuConcrete();

    @Override
    public GUIMenu createGUI() {
        this.GUIMenuConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.GUIMenuConcrete.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.GUIMenuConcrete.getTxtName().setColumns(SIZE_COLUMNS_TEXT);
        this.GUIMenuConcrete.setAllForeground(DesignSpace.color3);

        this.createGraphics();
        this.GUIMenuConcrete.validate();
        return GUIMenuConcrete;
    }

    private void createGraphics() {
        int nBtnUsed = N_BUTTONS;
        this.GUIMenuConcrete.setLayoutGUI(new GridBagLayout());
        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(80);

        this.GUIMenuConcrete.add(this.GUIMenuConcrete.getLbTitle(), lim);
        FactoryGUIs.resetGridBagContraints(lim);
        lim.gridy++;
        FactoryGUIs.setTransparentDesignJButton(this.GUIMenuConcrete.getButtons().get(IND_BUTTON_START));

        this.GUIMenuConcrete.add(FactoryGUIs.getUnionComponents(List.of(GUIMenuConcrete.getTxtName(),
                GUIMenuConcrete.getButtons().get(IND_BUTTON_START))), lim);
        nBtnUsed--;

        for (int i = (N_BUTTONS - nBtnUsed); i < nBtnUsed; i++) {
            lim.gridy++;
            FactoryGUIs.setTransparentDesignJButton(this.GUIMenuConcrete.getButton(i));
            this.GUIMenuConcrete.add(this.GUIMenuConcrete.getButton(i), lim);
        }
    }

}
