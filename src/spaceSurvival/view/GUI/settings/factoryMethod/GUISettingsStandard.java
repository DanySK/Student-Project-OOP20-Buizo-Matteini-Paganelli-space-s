package spaceSurvival.view.GUI.settings.factoryMethod;

import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.utilities.DesignSpace;
import spaceSurvival.view.GUI.settings.FactoryGUISettings;
import spaceSurvival.view.GUI.settings.GUISettings;
import spaceSurvival.view.GUI.settings.concrete.ConcreteGUISettings;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettingsStandard implements FactoryGUISettings {

    @Override
    public GUISettings create() {
        final ConcreteGUISettings concreteSettings = new ConcreteGUISettings();
        concreteSettings.setFontGUITitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_H1));
        concreteSettings.setFontTitleUnit(DesignSpace.FONT_BIG_STANDARD);
        concreteSettings.setFontUnit(DesignSpace.FONT_MEDIUM_STANDARD);
        concreteSettings.setForegroundGUI(DesignSpace.color4);
        concreteSettings.setBounds(Screen.RECTANGLE_MEDIUM);
        concreteSettings.setBorder(3);
        this.createGraphics(concreteSettings);
        return concreteSettings;
    }

    private void createGraphics(final ConcreteGUISettings concreteSettings) {
        concreteSettings.setBackgroundLayout(new BorderLayout());

        concreteSettings.add(FactoryGUIs.encapsulatesInPanelFlow(concreteSettings.getLbTitle()), BorderLayout.NORTH);
        concreteSettings.add(FactoryGUIs.encapsulatesInPanelFlow(concreteSettings.getBtnBack()), BorderLayout.SOUTH);

        FactoryGUIs.setIconJButtonFromRate(concreteSettings.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, concreteSettings.getWidth());
        concreteSettings.setTransparentComponent();

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        JPanel panelContainPanel = new JPanel(new GridBagLayout()) {{ setOpaque(false); }};

        panelContainPanel.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(List.of(
                FactoryGUIs.encapsulatesInPanelFlow(concreteSettings.getPanelSkin()),
                concreteSettings.getPanelDifficult()), DesignJComponent.SETTINGS_INSET), lim);

        concreteSettings.add(panelContainPanel, BorderLayout.CENTER);
    }
}
