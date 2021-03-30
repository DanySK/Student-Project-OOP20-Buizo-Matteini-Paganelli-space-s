package view.GUI.settings.factoryMethod;

import utilities.DesignSpace;
import view.GUI.settings.FactoryGUISettings;
import view.GUI.settings.GUISettings;
import view.GUI.settings.concrete.ConcreteGUISettings;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;

public class GUISettingsStandard implements FactoryGUISettings {
    private ConcreteGUISettings concreteSettingsGUI = new ConcreteGUISettings();

    @Override
    public GUISettings create() {
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
