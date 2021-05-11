package view.GUI.help.factoryMethod;

import utilities.IconPath;
import utilities.DesignJComponent;
import utilities.DimensionScreen;
import view.GUI.help.concrete.GUIHelpConcrete;
import view.GUI.help.FactoryGUIHelp;
import view.GUI.help.GUIHelp;
import utilities.DesignSpace;
import view.utilities.FactoryGUIs;

import java.awt.*;


public class GUIHelpStandard implements FactoryGUIHelp {

    @Override
    public GUIHelp create(){
        GUIHelpConcrete helpGUIConcrete = new GUIHelpConcrete();
        helpGUIConcrete.setFontTitleGUI(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_H1));
        helpGUIConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        helpGUIConcrete.setForegroundGUI(DesignSpace.color4);
        helpGUIConcrete.setBounds(DimensionScreen.RECTANGLE_MEDIUM);
        helpGUIConcrete.setBorder(3);
        this.createGraphics(helpGUIConcrete);
        return helpGUIConcrete;
    }

    private void createGraphics(final GUIHelpConcrete helpConcrete) {
        helpConcrete.setBackgroundLayout(new BorderLayout());

        helpConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(helpConcrete.getLbTitle()), BorderLayout.NORTH);
        helpConcrete.add(FactoryGUIs.encapsulatesInPanelFlow(helpConcrete.getBtnBack()), BorderLayout.SOUTH);

        helpConcrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(helpConcrete.getUnitHelps(), DesignJComponent.MIN_INSET),
                BorderLayout.CENTER);

        FactoryGUIs.setTransparentDesignJButton(helpConcrete.getBtnBack());
        FactoryGUIs.setIconJButtonFromRate(helpConcrete.getBtnBack(), IconPath.ICON_BACK,
                30, helpConcrete.getWidth());
    }
}
