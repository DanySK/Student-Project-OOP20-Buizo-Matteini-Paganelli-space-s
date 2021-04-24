package view.GUI.sound.factoryMethod;

import utilities.IconPath;
import utilities.DimensionScreen;
import utilities.DesignSpace;
import view.GUI.sound.FactoryGUISound;
import view.GUI.sound.GUISound;
import view.GUI.sound.concrete.ConcreteGUISound;
import view.utilities.FactoryGUIs;

import java.awt.*;

public class GUISoundStandard implements FactoryGUISound {

    @Override
    public GUISound create() {
        ConcreteGUISound soundGUI = new ConcreteGUISound();
        soundGUI.setFontGUITitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        soundGUI.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        soundGUI.setFontSpacingSlider(DesignSpace.FONT_MICRO_STANDARD);
        soundGUI.setForegroundGUI(DesignSpace.color4);

        soundGUI.setBounds(DimensionScreen.CENTER_X_MEDIUM, DimensionScreen.CENTER_Y_MEDIUM,
                DimensionScreen.WIDTH_MEDIUM, DimensionScreen.HEIGHT_MEDIUM);
        this.graphics(soundGUI);
        return soundGUI;
    }

    private void graphics(ConcreteGUISound soundGUI) {
        soundGUI.setBackgroundLayout(new BorderLayout());
        FactoryGUIs.setTransparentDesignJButton(soundGUI.getBtnBack());
        soundGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(soundGUI.getLbTitle()), BorderLayout.NORTH);
        soundGUI.add(soundGUI.getMixerSound(), BorderLayout.CENTER);
        soundGUI.add(FactoryGUIs.encapsulatesInPanel_Flow(soundGUI.getBtnBack()), BorderLayout.SOUTH);

        FactoryGUIs.setIconInJButtonMini(soundGUI.getBtnBack(), IconPath.ICON_BACK);
    }
}
