package view.factoryGUI.factorySettingsGUI.factoryMethod;

import utilities.DesignSpace;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.FactorySettingsGUI;
import view.factoryGUI.factorySettingsGUI.intefaceSettings.SettingsGUI;
import view.factoryGUI.factorySettingsGUI.settingsGUI.ConcreteSettingsGUI;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class SettingsGUIStandard implements FactorySettingsGUI {
    private ConcreteSettingsGUI concreteSettingsGUI = new ConcreteSettingsGUI();

    @Override
    public SettingsGUI create() {
        this.concreteSettingsGUI.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        this.concreteSettingsGUI.setFontTitlePanel(DesignSpace.FONT_BIG_STANDARD);
        this.concreteSettingsGUI.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        this.concreteSettingsGUI.setAllForeground(DesignSpace.color3);
        this.createGraphics();
        this.concreteSettingsGUI.validate();
        return concreteSettingsGUI;
    }

    private void createGraphics() {
        this.concreteSettingsGUI.setLayoutGUI(new BorderLayout());
        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(80);
        this.concreteSettingsGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(
                this.concreteSettingsGUI.getLbTitle()), BorderLayout.NORTH);

        this.concreteSettingsGUI.getPanelDifficult().setFocusable(false);

        FactoryGUIs.resetGridBagContraints(lim);
        JPanel panelContainPanel = new JPanel(new GridBagLayout());
        panelContainPanel.setOpaque(false);

        panelContainPanel.add(this.concreteSettingsGUI.getPanelSkin(), lim);
        lim.gridy++;
        panelContainPanel.add(this.concreteSettingsGUI.getPanelDifficult(), lim);
        lim.gridy++;
        panelContainPanel.add(this.concreteSettingsGUI.getPanelSound(), lim);

        this.concreteSettingsGUI.getPanelSkin().setTransparentButton();

        FactoryGUIs.setTransparentDesignJButton(this.concreteSettingsGUI.getBtnBack());

        FactoryGUIs.setIconInJButton(this.concreteSettingsGUI.getBtnBack(), "iconButton/iconBack.png");
        this.concreteSettingsGUI.add(panelContainPanel, BorderLayout.CENTER);
        this.concreteSettingsGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(this.concreteSettingsGUI.getBtnBack()),
                BorderLayout.SOUTH);

    }
}
