package view.GUI.help.factoryMethod;

import utilities.DesignJFrame;
import view.GUI.help.concrete.GUIHelpConcrete;
import view.GUI.help.FactoryGUIHelp;
import view.GUI.help.GUIHelp;
import view.GUI.help.utilities.HelpPanel;
import utilities.DesignSpace;
import view.utilities.FactoryGUIs;

import javax.swing.*;
import java.awt.*;


public class GUIHelpStandard implements FactoryGUIHelp {


    @Override
    public GUIHelp create(){
        GUIHelpConcrete helpGUIConcrete = new GUIHelpConcrete();
        helpGUIConcrete.setFontLbTitle(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_MAX));
        helpGUIConcrete.setAllFontNotLbTitle(DesignSpace.FONT_MEDIUM_STANDARD);
        helpGUIConcrete.setAllForeground(DesignSpace.color4);
        helpGUIConcrete.setBounds(DesignJFrame.GUI_X_MINI, DesignJFrame.GUI_Y_MINI,
                DesignJFrame.GUI_WIDTH_MINI, DesignJFrame.GUI_HEIGHT_MINI);
        this.createGraphics(helpGUIConcrete);
        return helpGUIConcrete;
    }

    private void createGraphics(final GUIHelpConcrete helpConcrete) {
        helpConcrete.setLayoutGUI(new BorderLayout());
        GridBagConstraints lim = FactoryGUIs.createGBConstraintsBase();
        helpConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(helpConcrete.getLbTitle()),
                BorderLayout.NORTH);

        JPanel panelContainPanel = new JPanel(new GridBagLayout());
        panelContainPanel.setOpaque(false);

        for (HelpPanel panelHelp : helpConcrete.getHelpPanels()) {
            panelContainPanel.add(panelHelp, lim);
            lim.gridy++;
        }

        helpConcrete.add(panelContainPanel, BorderLayout.CENTER);
        FactoryGUIs.setTransparentDesignJButton(helpConcrete.getBtnBack());
        FactoryGUIs.setIconInJButtonMini(helpConcrete.getBtnBack(), "iconButton/back.png");
        helpConcrete.add(FactoryGUIs.encapsulatesInPanel_Flow(helpConcrete.getBtnBack()), BorderLayout.SOUTH);
    }


}
