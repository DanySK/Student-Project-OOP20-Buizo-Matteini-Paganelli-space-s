package spaceSurvival.view.GUI.sound.factoryMethod;

import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.DesignSpace;
import spaceSurvival.view.GUI.sound.FactoryGUISound;
import spaceSurvival.view.GUI.sound.GUISound;
import spaceSurvival.view.GUI.sound.concrete.ConcreteGUISound;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;

public class GUISoundStandard implements FactoryGUISound {

    @Override
    public GUISound create() {
        ConcreteGUISound soundGUI = new ConcreteGUISound();
        soundGUI.setFontGUITitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_H1));
        soundGUI.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        soundGUI.setFontSpacingSlider(DesignSpace.FONT_MICRO_STANDARD);
        soundGUI.setForegroundGUI(DesignSpace.color4);
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
