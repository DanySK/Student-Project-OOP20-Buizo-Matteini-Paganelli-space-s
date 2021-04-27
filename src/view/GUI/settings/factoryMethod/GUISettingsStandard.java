package view.GUI.settings.factoryMethod;

import utilities.DimensionScreen;
import utilities.IconPath;
import utilities.DesignJComponent;
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
        concreteSettings.setFontTitleUnit(DesignSpace.FONT_BIG_STANDARD);
        concreteSettings.setFontUnit(DesignSpace.FONT_MEDIUM_STANDARD);
        concreteSettings.setForegroundGUI(DesignSpace.color4);
        concreteSettings.setBounds(DimensionScreen.RECTANGLE_MEDIUM);
        concreteSettings.setBorder(3);
        this.createGraphics(concreteSettings);
        return concreteSettings;
    }

    private void createGraphics(final ConcreteGUISettings concreteSettings) {
        concreteSettings.setBackgroundLayout(new BorderLayout());

        concreteSettings.add(FactoryGUIs.encapsulatesInPanel_Flow(concreteSettings.getLbTitle()), BorderLayout.NORTH);
        concreteSettings.add(FactoryGUIs.encapsulatesInPanel_Flow(concreteSettings.getBtnBack()), BorderLayout.SOUTH);

        FactoryGUIs.setIconJButtonFromRate(concreteSettings.getBtnBack(), IconPath.ICON_BACK,
                30, concreteSettings.getWidth());
        concreteSettings.setTransparentComponent();

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        JPanel panelContainPanel = new JPanel(new GridBagLayout()) {{ setOpaque(false); }};

        panelContainPanel.add(FactoryGUIs.encapsulatesVertical(List.of(
                FactoryGUIs.encapsulatesInPanel_Flow(concreteSettings.getPanelSkin()),
                concreteSettings.getPanelDifficult()), DesignJComponent.SETTINGS_INSET), lim);

        concreteSettings.add(panelContainPanel, BorderLayout.CENTER);
    }
}
