package spacesurvival.view.help.factoryMethod;

import spacesurvival.model.GUI.help.EngineHelp;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.pathImage.Background;
import spacesurvival.utilities.pathImage.Icon;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.view.help.concrete.GUIHelpConcrete;
import spacesurvival.view.help.FactoryGUIHelp;
import spacesurvival.view.help.GUIHelp;
import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.view.utilities.FactoryGUIs;

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
