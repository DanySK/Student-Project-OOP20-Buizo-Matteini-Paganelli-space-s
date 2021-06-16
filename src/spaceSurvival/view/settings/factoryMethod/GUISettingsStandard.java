package spacesurvival.view.settings.factoryMethod;

import spacesurvival.model.GUI.settings.EngineSettings;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.pathImage.Background;
import spacesurvival.utilities.pathImage.Icon;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.view.settings.FactoryGUISettings;
import spacesurvival.view.settings.GUISettings;
import spacesurvival.view.settings.concrete.GUISettingsConcrete;
import spacesurvival.view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettingsStandard implements FactoryGUISettings {

    @Override
    public GUISettings create() {
        final GUISettingsConcrete concreteSettings = new GUISettingsConcrete();
        concreteSettings.setFontGUITitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        concreteSettings.setFontTitleUnit(DesignGraphics.FONT_BIG_STANDARD);
        concreteSettings.setFontUnit(DesignGraphics.FONT_MEDIUM_STANDARD);
        concreteSettings.setForegroundGUI(DesignGraphics.COLOR_4);
        concreteSettings.setBorder(DesignGraphics.COLOR_4, 3);
        concreteSettings.setImageBackground(Background.MAIN);
        this.createGraphics(concreteSettings);
        return concreteSettings;
    }

    private void createGraphics(final GUISettingsConcrete concreteSettings) {
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
