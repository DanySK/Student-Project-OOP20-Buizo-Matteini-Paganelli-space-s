package view.sound.factoryMethod;

import utilities.dimension.ScaleOf;
import utilities.pathImage.Background;
import utilities.pathImage.Icon;
import utilities.dimension.Screen;
import view.utilities.DesignGraphics;
import view.sound.FactoryGUISound;
import view.sound.GUISound;
import view.sound.concrete.GUISoundConcrete;
import view.utilities.FactoryGUIs;

import java.awt.*;

public class GUISoundStandard implements FactoryGUISound {

    @Override
    public GUISound create() {
        final GUISoundConcrete soundGUI = new GUISoundConcrete();
        soundGUI.setFontGUITitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        soundGUI.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        soundGUI.setFontSpacingSlider(DesignGraphics.FONT_MICRO_STANDARD);
        soundGUI.setForegroundGUI(DesignGraphics.COLOR_4);
        soundGUI.setBounds(Screen.RECTANGLE_MEDIUM);
        soundGUI.setBorder(DesignGraphics.COLOR_4, 3);
        soundGUI.setImageBackground(Background.MAIN);
        this.graphics(soundGUI);
        return soundGUI;
    }

    private void graphics(final GUISoundConcrete soundGUI) {
        soundGUI.setLayout(new BorderLayout());
        FactoryGUIs.setTransparentDesignJButton(soundGUI.getBtnBack());
        soundGUI.add(FactoryGUIs.encapsulatesInPanelFlow(soundGUI.getLbTitle()), BorderLayout.NORTH);
        soundGUI.add(soundGUI.getMixerSound(), BorderLayout.CENTER);
        soundGUI.add(FactoryGUIs.encapsulatesInPanelFlow(soundGUI.getBtnBack()), BorderLayout.SOUTH);

        FactoryGUIs.setIconJButtonFromRate(soundGUI.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, soundGUI.getWidth());
    }
}
