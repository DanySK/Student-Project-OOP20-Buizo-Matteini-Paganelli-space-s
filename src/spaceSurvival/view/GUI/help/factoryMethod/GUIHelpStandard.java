package spaceSurvival.view.GUI.help.factoryMethod;

import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.view.GUI.help.concrete.GUIHelpConcrete;
import spaceSurvival.view.GUI.help.FactoryGUIHelp;
import spaceSurvival.view.GUI.help.GUIHelp;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;


public class GUIHelpStandard implements FactoryGUIHelp {

    @Override
    public GUIHelp create(){
        GUIHelpConcrete helpGUIConcrete = new GUIHelpConcrete();
        helpGUIConcrete.setFontTitleGUI(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        helpGUIConcrete.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        helpGUIConcrete.setForegroundGUI(DesignGraphics.color4);
        helpGUIConcrete.setBounds(Screen.RECTANGLE_MEDIUM);
        helpGUIConcrete.setBorder(3);
        this.createGraphics(helpGUIConcrete);
        return helpGUIConcrete;
    }

    private void createGraphics(final GUIHelpConcrete helpConcrete) {
        helpConcrete.setBackgroundLayout(new BorderLayout());

        helpConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(helpConcrete.getLbTitle()), BorderLayout.NORTH);
        helpConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(helpConcrete.getBtnBack()), BorderLayout.SOUTH);

        helpConcrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(
                helpConcrete.getUnitHelps(), DesignJComponent.MIN_INSET),
                BorderLayout.CENTER);

        FactoryGUIs.setTransparentDesignJButton(helpConcrete.getBtnBack());
        FactoryGUIs.setIconJButtonFromRate(helpConcrete.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, helpConcrete.getWidth());
    }
}
