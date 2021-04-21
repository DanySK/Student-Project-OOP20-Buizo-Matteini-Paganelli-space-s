package view.GUI.help.factoryMethod;

import utilities.IconPath;
import utilities.DesignJComponent;
import utilities.DesignJFrame;
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
        helpGUIConcrete.setFontTitleGUI(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        helpGUIConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        helpGUIConcrete.setForegroundGUI(DesignSpace.color4);
        helpGUIConcrete.setBounds(DesignJFrame.GUI_X_MINI, DesignJFrame.GUI_Y_MINI,
                DesignJFrame.GUI_WIDTH_MINI, DesignJFrame.GUI_HEIGHT_MINI);
        this.createGraphics(helpGUIConcrete);
        return helpGUIConcrete;
    }

    private void createGraphics(final GUIHelpConcrete helpConcrete) {
        helpConcrete.setBackLayoutGUI(new BorderLayout());

        helpConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(helpConcrete.getLbTitle()), BorderLayout.NORTH);
        helpConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(helpConcrete.getBtnBack()), BorderLayout.SOUTH);

        helpConcrete.add(FactoryGUIs.encapsulatesVertical(helpConcrete.getUnitHelps(), DesignJComponent.MIN_INSET),
                BorderLayout.CENTER);

        FactoryGUIs.setTransparentDesignJButton(helpConcrete.getBtnBack());
        FactoryGUIs.setIconInJButtonMini(helpConcrete.getBtnBack(), IconPath.ICON_BACK);
    }
}
