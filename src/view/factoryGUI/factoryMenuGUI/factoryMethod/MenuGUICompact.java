package view.factoryGUI.factoryMenuGUI.factoryMethod;

import utilities.DesignSpace;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.FactoryMenuGUI;
import view.factoryGUI.factoryMenuGUI.intefaceMenu.MenuGUI;
import view.factoryGUI.factoryMenuGUI.menuGUI.ConcreteMenuGUI;
import view.utilities.FactoryGUIs;

import java.awt.*;
import java.util.List;

public class MenuGUICompact implements FactoryMenuGUI {
    private final ConcreteMenuGUI concreteMenuGUI = new ConcreteMenuGUI();

    @Override
    public MenuGUI createGUI() {
        this.concreteMenuGUI.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.concreteMenuGUI.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.concreteMenuGUI.getTxtName().setColumns(SIZE_COLUMNS_TEXT);
        this.concreteMenuGUI.addButton(N_BUTTONS);
        this.createGraphics();
        this.concreteMenuGUI.validate();

        System.out.println(this.concreteMenuGUI.getName());

        return this.concreteMenuGUI;
    }

    private void createGraphics() {
        int nBtnUsed = N_BUTTONS;
        this.concreteMenuGUI.setLayoutGUI(new GridBagLayout());
        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(80);

        this.concreteMenuGUI.add(this.concreteMenuGUI.getLbTitle(), lim);
        FactoryGUIs.resetGridBagContraints(lim);
        lim.gridy++;
        this.concreteMenuGUI.add(FactoryGUIs.getUnionComponents(List.of(this.concreteMenuGUI.getTxtName(),
                this.concreteMenuGUI.getButtons().get(IND_BUTTON_START))), lim);
        nBtnUsed--;

        for (int i = (N_BUTTONS - nBtnUsed); i < nBtnUsed; i++) {
            lim.gridy++;
            this.concreteMenuGUI.add(FactoryGUIs.getUnionComponents(List.of(this.concreteMenuGUI.getButtons().get(i++),
                    this.concreteMenuGUI.getButtons().get(i))), lim);
            nBtnUsed--;
        }

    }




}
