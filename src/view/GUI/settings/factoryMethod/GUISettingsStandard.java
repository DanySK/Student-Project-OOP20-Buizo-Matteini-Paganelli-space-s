package view.GUI.settings.factoryMethod;

import utilities.DesignSpace;
import view.GUI.settings.FactoryGUISettings;
import view.GUI.settings.GUISettings;
import view.GUI.settings.concrete.ConcreteGUISettings;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettingsStandard implements FactoryGUISettings {

    @Override
    public GUISettings create() {
        final ConcreteGUISettings concreteSettings = new ConcreteGUISettings();

        concreteSettings.setFontGUITitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        concreteSettings.setFontTitlePanel(DesignSpace.FONT_BIG_STANDARD);
        concreteSettings.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        concreteSettings.setForegroundGUI(DesignSpace.color3);
        this.createGraphics(concreteSettings);
        return concreteSettings;
    }

    private void createGraphics(final ConcreteGUISettings concreteSettings) {
        concreteSettings.setLayoutGUI(new BorderLayout());
        concreteSettings.add(FactoryGUIs.encapsulatesInPanel_Flow(concreteSettings.getLbTitle()), BorderLayout.NORTH);
        concreteSettings.setTransparentComponent();

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        JPanel panelContainPanel = new JPanel(new GridBagLayout()) {{ setOpaque(false); }};

        panelContainPanel.add(FactoryGUIs.encapsulatesVertical(List.of(concreteSettings.getPanelSkin(),
                concreteSettings.getPanelDifficult()), 30), lim);
        lim.gridx += 2;
        panelContainPanel.add(concreteSettings.getPanelSound(), lim);


        concreteSettings.add(panelContainPanel, BorderLayout.CENTER);

        FactoryGUIs.setIconInJButton(concreteSettings.getBtnBack(), "iconButton/iconBack.png");
        concreteSettings.add(FactoryGUIs.encapsulatesInPanel_Flow(concreteSettings.getBtnBack()),
                BorderLayout.SOUTH);

    }
}
