package spaceSurvival.view.GUI.sound.factoryMethod;

import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.GUI.sound.FactoryGUISound;
import spaceSurvival.view.GUI.sound.GUISound;
import spaceSurvival.view.GUI.sound.concrete.ConcreteGUISound;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;

public class GUISoundStandard implements FactoryGUISound {

    @Override
    public GUISound create() {
        ConcreteGUISound soundGUI = new ConcreteGUISound();
        soundGUI.setFontGUITitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        soundGUI.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        soundGUI.setFontSpacingSlider(DesignGraphics.FONT_MICRO_STANDARD);
        soundGUI.setForegroundGUI(DesignGraphics.color4);
        soundGUI.setBounds(Screen.RECTANGLE_MEDIUM);
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

        FactoryGUIs.setIconJButtonFromRate(soundGUI.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, soundGUI.getWidth());
    }
}
