package spacesurvival.view.sound.factoryMethod;

import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.pathImage.Background;
import spacesurvival.utilities.pathImage.Icon;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.view.sound.FactoryGUISound;
import spacesurvival.view.sound.GUISound;
import spacesurvival.view.sound.concrete.GUISoundConcrete;
import spacesurvival.view.utilities.FactoryGUIs;

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
