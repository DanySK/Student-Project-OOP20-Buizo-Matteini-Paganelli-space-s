package spaceSurvival.view.settings.factoryMethod;

import spaceSurvival.model.GUI.settings.EngineSettings;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.settings.FactoryGUISettings;
import spaceSurvival.view.settings.GUISettings;
import spaceSurvival.view.settings.concrete.ConcreteGUISettings;
import spaceSurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettingsStandard implements FactoryGUISettings {

    @Override
    public GUISettings create() {
        final ConcreteGUISettings concreteSettings = new ConcreteGUISettings();
        concreteSettings.setFontGUITitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        concreteSettings.setFontTitleUnit(DesignGraphics.FONT_BIG_STANDARD);
        concreteSettings.setFontUnit(DesignGraphics.FONT_MEDIUM_STANDARD);
        concreteSettings.setForegroundGUI(DesignGraphics.color4);
        concreteSettings.setBorder(DesignGraphics.color4, 3);
        concreteSettings.setImageBackground(Background.MAIN);
        this.createGraphics(concreteSettings);
        return concreteSettings;
    }

    private void createGraphics(final ConcreteGUISettings concreteSettings) {
        concreteSettings.setLayout(new BorderLayout());

        concreteSettings.add(FactoryGUIs.encapsulatesInPanelFlow(concreteSettings.getLbTitle()), BorderLayout.NORTH);
        concreteSettings.add(FactoryGUIs.encapsulatesInPanelFlow(concreteSettings.getBtnBack()), BorderLayout.SOUTH);

        FactoryGUIs.setIconJButtonFromRate(concreteSettings.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, EngineSettings.RECTANGLE.width);
        concreteSettings.setTransparentComponent();

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        JPanel panelContainPanel = new JPanel(new GridBagLayout()) {{ setOpaque(false); }};

        panelContainPanel.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(List.of(
                FactoryGUIs.encapsulatesInPanelFlow(concreteSettings.getPanelSkin()),
                concreteSettings.getPanelDifficult()), DesignJComponent.SETTINGS_INSET), lim);

        concreteSettings.add(panelContainPanel, BorderLayout.CENTER);
    }
}
