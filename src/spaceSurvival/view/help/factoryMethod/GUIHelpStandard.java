package spaceSurvival.view.help.factoryMethod;

import spaceSurvival.model.GUI.help.EngineHelp;
import spaceSurvival.utilities.dimension.ScaleOf;
import spaceSurvival.utilities.pathImage.Background;
import spaceSurvival.utilities.pathImage.Icon;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.view.help.concrete.GUIHelpConcrete;
import spaceSurvival.view.help.FactoryGUIHelp;
import spaceSurvival.view.help.GUIHelp;
import spaceSurvival.view.utilities.DesignGraphics;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;


public class GUIHelpStandard implements FactoryGUIHelp {

    @Override
    public GUIHelp create(){
        GUIHelpConcrete helpGUIConcrete = new GUIHelpConcrete();
        helpGUIConcrete.setFontTitleGUI(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        helpGUIConcrete.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        helpGUIConcrete.setForegroundGUI(DesignGraphics.COLOR_4);
        helpGUIConcrete.setBorder(DesignGraphics.COLOR_4, 3);
        helpGUIConcrete.setImageBackground(Background.MAIN);
        this.createGraphics(helpGUIConcrete);
        return helpGUIConcrete;
    }

    private void createGraphics(final GUIHelpConcrete helpConcrete) {
        helpConcrete.setLayout(new BorderLayout());

        helpConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(helpConcrete.getLbTitle()), BorderLayout.NORTH);
        helpConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(helpConcrete.getBtnBack()), BorderLayout.SOUTH);

        helpConcrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(
                helpConcrete.getUnitHelps(), DesignJComponent.MIN_INSET),
                BorderLayout.CENTER);

        FactoryGUIs.setTransparentDesignJButton(helpConcrete.getBtnBack());
        FactoryGUIs.setIconJButtonFromRate(helpConcrete.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, EngineHelp.RECTANGLE.width);
    }
}
