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
        soundGUI.setBounds(DimensionScreen.RECTANGLE_MEDIUM);
        soundGUI.setBorder(3);
        this.graphics(soundGUI);
        return soundGUI;
    }

    private void graphics(ConcreteGUISound soundGUI) {
        soundGUI.setBackgroundLayout(new BorderLayout());
        FactoryGUIs.setTransparentDesignJButton(soundGUI.getBtnBack());
        soundGUI.add(FactoryGUIs.encapsulatesInPanelFlow(soundGUI.getLbTitle()), BorderLayout.NORTH);
        soundGUI.add(soundGUI.getMixerSound(), BorderLayout.CENTER);
        soundGUI.add(FactoryGUIs.encapsulatesInPanelFlow(soundGUI.getBtnBack()), BorderLayout.SOUTH);

        FactoryGUIs.setIconJButtonFromRate(soundGUI.getBtnBack(), IconPath.ICON_BACK,
                30, soundGUI.getWidth());
    }
}
