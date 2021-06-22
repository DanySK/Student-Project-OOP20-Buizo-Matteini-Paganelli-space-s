package spacesurvival.view.help.factorymethod;

import spacesurvival.model.gui.help.EngineHelp;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.path.Background;
import spacesurvival.utilities.path.Icon;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.view.help.concrete.GUIHelpConcrete;
import spacesurvival.view.help.FactoryGUIHelp;
import spacesurvival.view.help.GUIHelp;
import spacesurvival.view.utilities.GraphicsUtils;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.*;


public class GUIHelpStandard implements FactoryGUIHelp {

    @Override
    public GUIHelp create(){
        GUIHelpConcrete helpGUIConcrete = new GUIHelpConcrete();
        helpGUIConcrete.setFontTitleGUI(GraphicsUtils.getFontForTitle(GraphicsUtils.SIZE_FONT_H2));
        helpGUIConcrete.setFontGUI(GraphicsUtils.FONT_STANDARD_H5);
        helpGUIConcrete.setForegroundGUI(GraphicsUtils.COLOR_4);
        helpGUIConcrete.setBorder(GraphicsUtils.COLOR_4, 3);
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

        FactoryGUIs.setTransparentJButton(helpConcrete.getBtnBack());
        FactoryGUIs.setIconJButtonFromRate(helpConcrete.getBtnBack(), Icon.BACK,
                ScaleOf.ICON_MEDIUM, EngineHelp.RECTANGLE.width);
    }
}
