package view.factoryGUI.factoryHelpGUI.factoryMethod;

import view.factoryGUI.factoryHelpGUI.helpGUI.ConcreteHelpGUI;
import view.factoryGUI.factoryHelpGUI.FactoryHelpGUI;
import view.factoryGUI.factoryHelpGUI.HelpGUI;
import view.factoryGUI.factoryHelpGUI.utilities.PanelHelp;
import utilities.DesignSpace;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;


public class HelpGUIStandard implements FactoryHelpGUI {
    private ConcreteHelpGUI concreteHelpGUI = new ConcreteHelpGUI();

    @Override
    public HelpGUI create(){
        this.concreteHelpGUI.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.concreteHelpGUI.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.concreteHelpGUI.setAllForeground(DesignSpace.color3);
        this.createGraphics();
        this.concreteHelpGUI.validate();
        return this.concreteHelpGUI;
    }

    private void createGraphics() {
        this.concreteHelpGUI.setLayoutGUI(new BorderLayout());
        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        this.concreteHelpGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(this.concreteHelpGUI.getLbTitle()),
                BorderLayout.NORTH);

        JPanel panelContainPanel = new JPanel(new GridBagLayout());
        panelContainPanel.setOpaque(false);

        for (PanelHelp panelHelp : this.concreteHelpGUI.getHelpPanels()) {
            panelContainPanel.add(panelHelp, lim);
            lim.gridy++;
        }

        this.concreteHelpGUI.add(panelContainPanel, BorderLayout.CENTER);
        FactoryGUIs.setTransparentDesignJButton(this.concreteHelpGUI.getBtnBack());
        FactoryGUIs.setIconInJButton(this.concreteHelpGUI.getBtnBack(), "iconButton/iconBack.png");
        this.concreteHelpGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(this.concreteHelpGUI.getBtnBack()), BorderLayout.SOUTH);
    }


}
